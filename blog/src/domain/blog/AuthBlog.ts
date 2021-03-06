import { oneLineTrim } from 'common-tags'

import { Auth } from '../../service/Auth'
import { UserRepository } from '../../service/UserRepository'
import { Page } from '../Page'
import { User } from '../User'
import { Blog } from './Blog'

export class AuthBlog implements Blog {
  private auth: Auth

  constructor(private blog: Blog, private users: UserRepository) {
    this.auth = new Auth(users)
  }

  public register(username: string, password: string, role?: string): void {
    this.auth.register(username, password, role)
  }

  public login(username: string, password: string): void {
    this.auth.login(username, password)
  }

  public logout(): void {
    this.auth.logout()
  }

  public getUsers(): User[] {
    if (!this.auth.isAdmin()) {
      throw new Error('You cannot perform this operation.')
    }
    return this.users.all()
  }

  public renderAddPage(): string {
    if (!this.auth.isAdmin()) {
      throw new Error('You cannot perform this operation.')
    }
    const renderedPage = this.blog.renderAddPage()
    return this.renderLayout(renderedPage)
  }

  public addPage(title: string, body: string): string {
    if (!this.auth.isAdmin()) {
      throw new Error('You cannot perform this operation.')
    }
    return this.blog.addPage(title, body)
  }

  public getPages(): Page[] {
    return this.blog.getPages()
  }

  public renderPage(id: string): string {
    const renderedPage = this.blog.renderPage(id)
    return this.renderLayout(renderedPage)
  }

  public renderAddPost(): string {
    if (this.auth.getUser() == null) {
      throw new Error('You must be logged in.')
    }
    const renderedPage = this.blog.renderAddPost()
    return this.renderLayout(renderedPage)
  }

  public addPost(title: string, body: string, date: Date): string {
    if (this.auth.getUser() == null) {
      throw new Error('You must be logged in.')
    }
    const username = this.auth.getUser().getUsername()
    return this.blog.addPost(title, body, date, username)
  }

  public renderPost(id: string): string {
    const renderedPage = this.blog.renderPost(id)
    return this.renderLayout(renderedPage)
  }

  public renderFeaturedPosts(author?: string): string {
    const renderedPage = this.blog.renderFeaturedPosts(author)
    return this.renderLayout(renderedPage)
  }

  public renderRegister(): string {
    const renderedPage = oneLineTrim`
      <nav>
        <ul>
          <li><a href="javascript:history.back()">Back</a></li>
        </ul>
      </nav>
      <main>
        <h1>Sign On</h1>
        <form action="/register" method="POST">
          <label>Username</label>
          <input name="username" autofocus autocomplete="off" /><br />
          <label>Password</label>
          <input name="password" type="password" /><br />
          <button type="submit">Sign On</button>
        </form>
      </main>
    `
    return this.renderLayout(renderedPage)
  }

  public renderLogin(): string {
    const renderedPage = oneLineTrim`
      <nav>
        <ul>
          <li><a href="javascript:history.back()">Back</a></li>
        </ul>
      </nav>
      <main>
        <h1>Sign In</h1>
        <form action="/login" method="POST">
          <label>Username</label>
          <input name="username" autofocus autocomplete="off" /><br />
          <label>Password</label>
          <input name="password" type="password" /><br />
          <button type="submit">Sign In</button>
        </form>
      </main>
    `
    return this.renderLayout(renderedPage)
  }

  public renderError(error): string {
    const renderedPage = oneLineTrim`
      <nav>
        <ul>
          <li><a href="javascript:history.back()">Back</a></li>
        </ul>
      </nav>
      <main>
        <h1>Sorry</h1>
        <p>${error.message}</p>
      </main>
    `
    return this.renderLayout(renderedPage)
  }

  private renderLayout(renderedPage: string): string {
    const user = this.auth.getUser()

    const authMenu =
      user != null
        ? oneLineTrim`
            <li><span>Welcome, ${user.getUsername()}!</span></li>
            <li><a href="/logout">Sign out</a></li>
          `
        : oneLineTrim`
            <li><a href="/register">Sign On</a></li>
            <li><a href="/login">Sign In</a></li>
          `

    const actionMenu =
      user != null
        ? oneLineTrim`
            ${
              this.auth.isAdmin()
                ? '<li><a href="/add-page">Add Page</a></li>'
                : ''
            }
            <li><a href="/add-post">Add Post</a></li>
          `
        : ''

    return oneLineTrim`
      <nav>
        <ul>
          ${authMenu}
        </ul>
      </nav>
      ${renderedPage}
      <nav>
        <ul>
          ${actionMenu}
        </ul>
      </nav>
    `
  }
}

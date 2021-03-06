import { oneLineTrim } from 'common-tags'

import { PostRepository } from '../service/PostRepository'
import { UserRepository } from '../service/UserRepository'
import { toId } from '../service/utils'
import { Page } from './Page'
import { User } from './User'

export class FeaturedPosts implements Page {
  private id: string
  private title = 'Featured Posts'

  constructor(private posts: PostRepository, private users: UserRepository) {
    this.id = toId(this.title)
  }

  public getId(): string {
    return this.id
  }

  public getTitle(): string {
    return this.title
  }

  public render(author?: User): string {
    const body = this.posts
      .all(author)
      .map(post => post.renderPreview())
      .join('')

    return oneLineTrim`
      <article>
        <h1>${this.title}</h1>
        <div>
          Filter:
          <a href="/pages/featured-posts?author=">all</a>
          ${this.users
            .all()
            .map(this.getUserLink)
            .join('')}
        </div>
      </article>
      ${body.length ? body : '<article>No posts yet.</article>'}
    `
  }

  private getUserLink(user) {
    return `<a href="/pages/featured-posts?author=${user.getUsername()}">${user.getUsername()}</a>`
  }
}

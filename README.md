# xp-tdd

Reference code for a course on eXtreme Programming and Test-Driven Development.

## Blog

The `blog` folder is a Node project. It's a role-playing game in which the teacher pretends to be a client that has a rough idea of what they want. At first they just know they want a Wordpress-style blog, but then a few features emerge (and they should be stated as obscure as possible):

1. Posts have a title, a body, an author and a date.
2. Every post should be rendered as HTML.
3. Apart from posts, the blog has pages such as About or Contacts.
4. Pages have a title and a body, and should be rendered as HTML as well.
5. Every page and post has a unique id which is the title's slugified version.
6. When created, the blog should have at least a stub homepage.
7. The blog should also have a "featured posts" page: it shows title, author's nickname, and date for every post, and also provides a link to the post.
8. The "featured posts" page should show a "no posts yet" message if there are no posts.
9. The list of featured posts can be filtered by author's nickname.
10. The blog should have some authentication.
11. When created, the blog shoud have at least one admin user.
12. Users can sign on, and will have a default role of "Authenticated".
13. Users can also sign in and sign out.
14. Any user can just add posts and read all kinds of pages, while an admin can also add new pages and get a list of users.
15. The blog should display all available pages on a menu.

## Java

The `java` folder is an Eclipse/NetBeans project. There are three examples here:

1. Button: a very badly written code, refactored into something more readable.
2. Mario: a representation of Nintendo's famous character, with powerups added through different kinds of solutions:
   1. God Object: one object with a nested switch/case based on type
   2. Hierarchy: A BaseMario class is extended by the superpowered classes
   3. State: BaseMario behaves differently depending on the state it holds
   4. Decorator: the different behaviors can be added and combined at runtime
3. Christmas Tree: an experiment on decorators and TDD, in which we build a complex Christmas tree with parametric height by splitting the problem into multiple simpler subproblems. The end result will look like this:

```
     qp
    ì/\ì
   ì/ *\ì
  ì/o* o\ì
 ì/ o*  *\ì
ì/**  *   \ì
 ----------
     ||
```

There is also an example in which the decorators we built can decorate any kind of tree. For example, a Christmas oak tree will look like this:

```
     qp
ì/--------\ì
ì| o   oo |ì
ì|   *oo  |ì
ì\--------/ì
    \\//
     ||
     ||
```

Every example is purposedly non-commented and solely documented through unit tests.

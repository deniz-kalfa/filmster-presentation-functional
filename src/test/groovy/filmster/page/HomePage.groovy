package filmster.page

import filmster.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "Welcome to Filmster Presentation" }

  static content = {
    items { $('.item') }
  }
}

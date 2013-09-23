package filmster.page

import filmster.page.module.TableModule
import filmster.path.PathPresentation

class StatusPage extends BasePage {
  static url = PathPresentation.STATUS

  static at = {
    title == "Filmster Presentation Admin"
    header.text() == "Filmster Presentation Status"
  }

  static content = {
    header { $("h2") }

    status(required: false) { name -> module TableModule, $(".$name")}
  }
}

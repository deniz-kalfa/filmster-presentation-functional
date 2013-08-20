package filmster.page

import filmster.page.module.TableModule
import filmster.path.PathPresentation

class StatusPage extends BasePage {
  static url = PathPresentation.STATUS

  static at = {
    title == "Filmster Presentation Status"
    header.text() == "Filmster Presentation Status"
  }

  static content = {
    header { $("h2") }

    endpoints { module TableModule, $(".endpoints")}

    welcomeField { $('.welcomeField') }
    welcomeText { $('.welcomeText') }
  }
}

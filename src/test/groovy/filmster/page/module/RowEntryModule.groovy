package filmster.page.module

import geb.Module

class RowEntryModule extends Module {
  static content = {
    cells { $('td') }
  }
}

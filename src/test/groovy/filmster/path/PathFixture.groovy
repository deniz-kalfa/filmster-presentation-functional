package filmster.path

import filmster.spec.BaseSpecification

enum PathFixture {
  BASE(BaseSpecification.config.presentation.baseContext + "/admin/fixture"),
  RESET("$BASE/reset"),
  STATUS("$BASE/status")

  String path

  PathFixture(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}
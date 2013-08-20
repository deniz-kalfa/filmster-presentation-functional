package filmster.spec

import filmster.page.HomePage
import filmster.path.PathFixture

class HomePageSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    given:
      presentation.get(path: PathFixture.RESET)

    when:
      to HomePage

    then:
      at HomePage
  }
}

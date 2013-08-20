package filmster.spec

import filmster.page.StatusPage
import filmster.path.PathFixture
import filmster.path.PathPresentation
import groovyx.net.http.ContentType

class StatusPageSpec extends BaseSpecification {

  def setup(){
    presentation.get(path: PathFixture.RESET)
  }

  def "Status page renders endpoints"() {
    given:
      presentation.post(path: "${PathFixture.STATUS}",
                        requestContentType: ContentType.JSON,
                        body: [status: [
                          [name: 'application', properties: [version: '1234', git_commit: 'xyz123456']],
                          [name: 'health', properties: [home_page: 'ok']]
                        ]])

    when:
      toAt StatusPage

    then:
      status('application').header.text() == 'Application'
      status('application').rows[0].cells*.text() == ["version", "1234"]
      status('application').rows[1].cells*.text() == ["git_commit", "xyz123456"]

    and:
      status('health').header.text() == 'Health'
      status('health').rows[0].cells*.text() == ["home_page", "ok"]
  }

  def "Status should be available as json feed"() {
    given:
      presentation.post(path: "${PathFixture.STATUS}",
                        requestContentType: ContentType.JSON,
                        body: [status: [
                          [name: 'application', properties: [version: '1234', git_commit: 'xyz123456']],
                          [name: 'health', properties: [home_page: 'ok']]
                        ]])

    when:
      def response = presentation.get(path: "${PathPresentation.STATUS}",
                                      headers: ['Accept': 'application/json'])

    then:
      def status = response.data.status
      status[0] == [name: 'application', properties: [version: '1234', git_commit: 'xyz123456']]
      status[1] == [name: 'health', properties: [home_page: 'ok']]
  }
}
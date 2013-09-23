package filmster

presentation {
  baseUrl = "http://localhost:5000"
  baseContext = ""
}
stubulator {
  baseUrl = "http://localhost:5001"
  baseContext = ""
}

environments {
  functional01 {
    presentation {
      baseUrl = "http://filmster-presentation-func01.herokuapp.com/"
      baseContext = ""
    }
    stubulator  {
      baseUrl = "http://filmster-presentation-stub01.herokuapp.com/"
      baseContext = ""
    }
  }
}
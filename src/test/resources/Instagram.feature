Feature: Instagram Automation
  Verifying most of instagram automation

  @Test
  Scenario: Login and verify its navigating to home page
    Given We enter username in instagram page
    Then We enter password in instagram page
    Then We click login button
    Then We verifying that we navigating to home page

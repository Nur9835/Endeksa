@login
Feature:Login
  Scenario Outline: E-mail ile hesaba giriş(pozitif senaryo,negatif senarolar)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And E-posta alanına "<email>" Parola alanına "<password>" girilir ve Giriş Yap butonu tıklanır
    Then Hesaba  "<email>" giriş yaptığı doğrulanır

    Examples:
      | email                | password      |
      |  testnur9@gmail.com  | TEST1234      |
      |  testnur9@gmail.com  |               |
      |                      | TEST1234      |
      |  testnur9@gmail.com  | TESTDENEME    |
      |  testnur9@gmail.com  | 12345678      |


@login2


  Scenario Outline: Telefon numarası ile hesaba giriş(pozitif senaryo,negatif senarolar)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    Then Hesaba telefon numarası ile "<phone>" giriş yaptığı doğrulanır

    Examples:
      | phone          |
      |  5069846802    |
      |  55555555      |
      |  abcddef       |
      |                |
      |  abcd222       |



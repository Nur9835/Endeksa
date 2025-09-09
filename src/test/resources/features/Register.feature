@register
Feature:Kayıt Olma
  Scenario Outline: E-mail ile  kayıt olmak (pozitif senaryo,negatif senarolar)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Kullanım sözleşmesini onayla
    And Gizlilik sözleşmesini onayla
    And Üye ve Ziyaretçi Aydınlatma sözleşmesini onayla
    And Kaydol butonuna tıklanır


    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |
      |           | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 | DENEMETest12345  |
      | Nur       |          | hnk9833@gmail.com   | DENEMETest12345 | DENEMETest12345  |
      | Nur       | Kılıç    |                     | DENEMETest12345 | DENEMETest12345  |
      | Nur       | Kılıç    | hnk9833@gmail.com   |                 | DENEMETest12345  |
      | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |                  |




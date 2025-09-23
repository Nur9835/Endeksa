@login1
Feature:Login
  Scenario Outline: E-mail ile hesaba giriş(pozitif senaryo)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And E-posta alanına "<email>" Parola alanına "<password>" girilir
    And Giriş Yap butonu tıklanır
    Then Hesaba  "<email>" giriş yaptığı doğrulanır

    Examples:
      | email                | password          |
      |  hnk9833@gmail.com   | DENEMETest12345   |


  @login7
  Scenario Outline: Telefon numarası ile hesaba giriş(Negatif senaryo- Eksik/Hatalı telefon numarası, Telefon numarası boş bırakılması )
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonunun disable tıklanamaz olduğu doğrulanır

    Examples:
      | phone          |
      |  55555555      |
      |  abcddef       |
      |  abcd222       |
      |                |

  @login3
  Scenario Outline: E-mail ile hesaba giriş Negatif Senaryo- (Doğru e-posta boş Parola, Doğru e-posta yanlış parola)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And  E-posta alanına "<email>" Parola alanına "<password>" girilir
    Then Giriş yap butonunun disable tıklanamaz olduğu doğrulanır
    Examples:
      |  email              | password      |
      |  hnk9833@gmail.com  |               |
      |  hnk9833@gmail.com  | TESTDENEME    |
      |  hnk9833@gmail.com  | 12345678      |
      |  hnk9833@gmail.com  | 12345678      |


  @login5
  Scenario Outline: Telefon numarası ile hesaba giriş(pozitif senaryo)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    Then Hesaba telefon numarası ile "<phone>" giriş yaptığı doğrulanır

    Examples:
      | phone          |
      |  5069846802    |

  @login4
  Scenario Outline: E-mail ile hesaba giriş Negatif Senaryo- Hatalı/Eksik e-posta adresi ile
    Given Web sitesine gidilir
    When Eposta ile giriş
    And  E-posta alanına "<email>" Parola alanına "<password>" girilir
    Then Hatalı parola veya e-posta adresi uyarısı alındığı doğrulanır
    Examples:
      | email                | password       |
      |  hnk9833@gmail.co    |DENEMETest12345 |




  @login6
  Scenario Outline: Telefon numarası ile hesaba giriş(Negatif senaryo- Doğrulama kodu yanlış girilmesi sonucu)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulamada hatalı kod yazılır
    Then Hatalı OTP kodu. Lütfen tekrar deneyin uyarısı alındığı doğrulanır

    Examples:
      | phone          |
      |  5069846802    |





  @login8
  Scenario Outline: Önceden kayıtlı olmayan telefon numarası ile giriş yapılmaya çalışılması durumunda Register işlemleri başlar (E-posta girmeden)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    And E-Posta ekleme alanında Bu Adımı Atla butonuna tıklanır ve çıkan Alert onaylanır
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Ekrana Register işleminin devamı için çıkan popup'daki zorunlu alanlar "<firstName>", "<lastName>"  girilir
    Then Hesaba telefon numarası ile "<phone>" kayıt yaptığı doğrulanır

    Examples:
      | phone          | firstName | lastName |
      |  5069846802    | Nur       | Kılıç    |


  @login9
  Scenario Outline: Önceden kayıtlı olmayan telefon numarası ile giriş yapılmaya çalışılması durumunda Register işlemleri başlar (E-posta girilerek -Doğrulamadan )
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    And E-Posta ekleme alanına e-posta adresi "<email>" girilir
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Ekrana Register işleminin devamı için çıkan popup'daki zorunlu alanlar "<firstName>", "<lastName>"  girilir
    Then Hesaba telefon numarası ile "<phone>"  ve mail adresi "<email>"  ile kayıt yaptığı doğrulanır

    Examples:
      | phone          | firstName | lastName |email                |
      |  5069846802    | Nur       | Kılıç    | hnk9833@gmail.com   |



@login10
Scenario Outline: Mevcut Hesap Silme işlemi gerçekleştikten sonra silinen e-posta ile giriş yapılmaya çalışılması
  Given Web sitesine gidilir
  When Eposta ile giriş
  And E-posta alanına "<email>" Parola alanına "<password>" girilir
  And Giriş Yap butonu tıklanır
  Then Hesaba  "<email>" giriş yaptığı doğrulanır
  When Profil sayfasındaki Hesabı Sil butonuna tıklanır
  And Çıkan popupdaki inputa "<keyString>" girilir
  And Sil butonunun enable olduğu doğrulanır ve tıklanır
  Then Ana sayfaya yönlendirdiği doğrulanır
  When Eposta ile giriş
  And E-posta alanına "<email>" Parola alanına "<password>" girilir
  And Giriş Yap butonu tıklanır
  Then Hatalı parola veya e-posta adresi uyarısı alındığı doğrulanır

  Examples:
    | email                | password          | keyString |
    |  hnk9833@gmail.com   | DENEMETest12345   | hesabı sil|



  @login11
  Scenario Outline: Mevcut Hesap Silme işlemi gerçekleştikten sonra silinen telefon numarası ile giriş yapılmaya çalışılması durumunda Register sayfasına yönlendiir
  (E-posta adresi girmeden)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    Then Hesaba telefon numarası ile "<phone>" giriş yaptığı doğrulanır
    When Profil sayfasındaki Hesabı Sil butonuna tıklanır
    And Çıkan popupdaki inputa "<keyString>" girilir
    And Sil butonunun enable olduğu doğrulanır ve tıklanır
    Then Ana sayfaya yönlendirdiği doğrulanır
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    And E-Posta ekleme alanında Bu Adımı Atla butonuna tıklanır ve çıkan Alert onaylanır
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Ekrana Register işleminin devamı için çıkan popup'daki zorunlu alanlar "<firstName>", "<lastName>"  girilir
    Then Hesaba telefon numarası ile "<phone>" kayıt yaptığı doğrulanır

    Examples:
      | phone          | firstName | lastName | keyString |
      |  5069846802    | Nur       | Kılıç    | hesabı sil|



  @login2
  Scenario Outline: E-mail ile hesaba giriş Negatif Senaryo- (Önceden kayıtlı olmayan e-posta ile giriş yapılması, E-posta alanının boş bırakılması)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And  E-posta alanına "<email>" Parola alanına "<password>" girilir
    Then One or more validation errors occurred uyarısı alındığı doğrulanır
    Examples:
      | email                | password         |
      |  hnk-98@hotmail.com  | 12345            |
      |  hnk-98@hotmail.com  | TestDeneme22     |
      |                      | DENEMETest12345  |

  @login12
  Scenario Outline: Mevcut Hesap Silme işlemi gerçekleştikten sonra silinen telefon numarası ile giriş yapılmaya çalışılması durumunda Register sayfasına yönlendiir
  (E-posta adresi girilerek)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    Then Hesaba telefon numarası ile "<phone>" giriş yaptığı doğrulanır
    When Profil sayfasındaki Hesabı Sil butonuna tıklanır
    And Çıkan popupdaki inputa "<keyString>" girilir
    And Sil butonunun enable olduğu doğrulanır ve tıklanır
    Then Ana sayfaya yönlendirdiği doğrulanır
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    And E-Posta ekleme alanına e-posta adresi "<email>" girilir
    And E-posta adresine gönderilen kod E-posta doğrulama alanına eksiksiz girilir ve Doğrula butonu tıklanır
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Ekrana Register işleminin devamı için çıkan popup'daki zorunlu alanlar "<firstName>", "<lastName>"  girilir
    Then Hesaba telefon numarası ile "<phone>"  ve mail adresi "<email>"  ile kayıt yaptığı doğrulanır

    Examples:
      | phone          | firstName | lastName |  email              | keyString |
      |  5069846802    | Nur       | Kılıç    | hnk9833@gmail.com   | hesabı sil|




@register1
Feature:Kayıt Olma
  Scenario Outline: E-mail ile  kayıt olmak (pozitif senaryo(sadece zorunlu alanlar),
    negatif seneryolar (zorunlu alanların boş bırakılması, Ad ve Soyad alanları numeric
  ))
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
      | 101       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |
      | Nur       | 1011     | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |



  @register2
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Parola  en az 8 karakter olmalı
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Parola en az sekiz karakter olmalı uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | NUR             |  NUR             |
      | Nur       | Kılıç    | hnk9833@gmail.com   | 0020            |  0020            |
      | Nur       | Kılıç    | hnk9833@gmail.com   | NUR00           |  NUR00           |
      | Nur       | Kılıç    | hnk9833@gmail.com   | nUR022          |  nUR022          |



  @register3
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Parola 8 karakterden fazla fakat en az 1 harf veya rakam içermeyen
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Parola  "<password>" en az bir rakam ve bir harf içermeli

    Examples:
      | firstName | lastName | email               | password       |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | 123456788      |  123456788       |
      | Nur       | Kılıç    | hnk9833@gmail.com   | 12345678       |  123456788       |
      | Nur       | Kılıç    | hnk9833@gmail.com   | TestNurD       |  123456788       |
      | Nur       | Kılıç    | hnk9833@gmail.com   | EndeksaTestNur |  EndeksaTestNur  |
      | Nur       | Kılıç    | hnk9833@gmail.com   | !!!@@@###      |  !!!@@@###       |



  @register4
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Parola kurallara uygun olmalı ,Sınır değer analizi
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Parolada herhangi bir uyarı vermemeli

    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | Test3406        |  Test3406        |



  @register5
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Kullanılan e-posta )
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Kullanılan e-posta adresi uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |


  @register6
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Hatalı e-mail formatı )
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Geçersiz e-posta uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | nur@gmail.co        | DENEMETest12345 |  DENEMETest12345 |



  @register7
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo -Eksik/hatalı telefon numarası )
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>"  Telefon numarasına "<phone>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Geçersiz telefon numarasıı uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               |  phone       |  password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | 555555       |  DENEMETest12345 |  DENEMETest12345 |
      | Nur       | Kılıç    | hnk9833@gmail.com   | ASDF44       |  DENEMETest12345 |  DENEMETest12345 |



  @register8
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo - Önceden kayıtlı telefon numarası )
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>"  Telefon numarasına "<phone>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Kullanılan telefon numarası uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               |  phone           |  password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | 5069846802       |  DENEMETest12345 |  DENEMETest12345 |



  @register9
  Scenario Outline: E-mail ile  kayıt olmak (negatif seneryo - Parola ile Parola Tekrarı uyuşmaması)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    Then Parolalar eşleşmiyor uyarısı alındığı doğrulanır

    Examples:
      | firstName | lastName | email               |   password       |confirmPassword    |
      | Nur       | Kılıç    | hnk9833@gmail.com   |  DENEMETest12345 |  DENEMETest12347  |



  @register10
  Scenario Outline: E-mail ile  kayıt olmak ( Negatif Senaryo- Kullanım sözleşmesi onaylanmadan)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
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



  @register11
  Scenario Outline: E-mail ile  kayıt olmak ( Negatif Senaryo- Gizlilik sözleşmesi onaylanmadan)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Kullanım sözleşmesini onayla
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


  @register12
  Scenario Outline: E-mail ile  kayıt olmak ( Negatif Senaryo- Üye ve Ziyaretçi Aydınlanma sözleşmesi onaylanmadan)
    Given Web sitesine gidilir
    When Eposta ile giriş
    And Ücretsiz Kaydol bağlantısına tıklanır
    Then Register sayfasına yönlendirildiği doğrulanır
    When Ad alanına "<firstName>", Soyad alanına "<lastName>", E-posta alanına "<email>" Parola alanına "<password>" ve Parola Tekrarına "<confirmPassword>" girilir
    And Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden "Özel Sektör Çalışanıyım" seçilir
    And Kullanım sözleşmesini onayla
    And Gizlilik sözleşmesini onayla
    And Kaydol butonuna tıklanır


    Examples:
      | firstName | lastName | email               | password        |confirmPassword   |
      | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |
      |           | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 | DENEMETest12345  |
      | Nur       |          | hnk9833@gmail.com   | DENEMETest12345 | DENEMETest12345  |
      | Nur       | Kılıç    |                     | DENEMETest12345 | DENEMETest12345  |
      | Nur       | Kılıç    | hnk9833@gmail.com   |                 | DENEMETest12345  |
      | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |                  |


    @register13
    Scenario Outline: E-mail ile kayıt olunduktan sonra önceden kayıtlı telefon numarasını hesaba eklenmesi
     (aynı telefon numarasından hesabından birden fazla hesap olmamalı)
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
      Then Hesaba giriş yapıldığı doğrulanır
      When Kullanıcı bilgileri sayfasına gidilir
      And  Kullanıcı bilgilerindeki Telefon numarası inputuna  telefon numarası "<phone>" alanına girilir
      Then Kullanılan telefon numarası uyarısı alındığı doğrulanır
      Examples:
        | firstName | lastName | email               | password        |confirmPassword   |phone  |
        | Nur       | Kılıç    | hnk9833@gmail.com   | DENEMETest12345 |  DENEMETest12345 |05069846802|


  @register14
  Scenario Outline: Telefon numarası ile  kayıt olma(E-posta adresi girmeden)
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


  @register15
  Scenario Outline: Telefon numarası ile  kayıt olma(Önceden kayıtlı olmayan E-posta adresi girilerek)
    Given Web sitesine gidilir
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
      | phone          | firstName | lastName |  email              |
      |  5069846802    | Nur       | Kılıç    | hnk9833@gmail.com   |



  @register16
  Scenario Outline: Telefon numarası ile  kayıt olma( Önceden kayıtlı E-posta adresi girilerek)
    Given Web sitesine gidilir
    When Kaydol Giriş Yap butonu tıklanır
    And Telefon numarası alanına "<phone>" girilir
    And Ücretsiz Kaydol Giriş Yap butonu tıklanır
    And sms doğrulama
    And E-Posta ekleme alanına e-posta adresi "<email>" girilir
    Then Kullanılan e-posta adresi uyarısı alındığı doğrulanır

    Examples:
      | phone          |  email              |
      |  5069846802    | hnk9833@gmail.com   |



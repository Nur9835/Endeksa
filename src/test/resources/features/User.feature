
  Feature:Kullanıcı İşlemleri
//Her senaryodan önce Register ve ardondan Login işlemi yapılır
    Background:
      Given Web sitesine gidilir
      When Eposta ile giriş
      And E-posta   Parola alanına  girilir
      And Giriş Yap butonu tıklanır
      Then Hesaba  "<email>" giriş yaptığı doğrulanır



    @user2
    Scenario Outline: Şifre güncelleme sayfasında Şifre  en az 8 karakter olmalı (E-mail ile kayıt olunmuş hesapta)
      When Profil sayfasındaki Parola Değiştir butonuna tıklanır
      And  Mevcut Parola alanına "<oldPassword>" ve Yeni Parola alanına "<newPassword>" Yeni Parola Tekrarı alanına "<newConfirmPassword>" girilir
      Then Parola en az sekiz karakter olmalı uyarısı alındığı doğrulanır

      Examples:
        | newPassword      |newConfirmPassword | oldPassword      |
        | NUR              | NUR               | DENEMETest12345  |
        | 0020             | 0020              | DENEMETest12345  |
        | NUR00            | 0020              | DENEMETest12345  |


    @user3
    Scenario Outline: Şifre güncelleme sayfasında Şifre 8 karakterden fazla fakat en az 1 harf veya rakam içermeli (E-mail ile kayıt olunmuş hesapta)
      When Profil sayfasındaki Parola Değiştir butonuna tıklanır
      And  Mevcut Parola alanına "<oldPassword>" ve Yeni Parola alanına "<newPassword>" Yeni Parola Tekrarı alanına "<newConfirmPassword>" girilir
      Then Parola  "<newPassword>" en az bir rakam ve bir harf içermeli

      Examples:
        | newPassword      | newConfirmPassword | oldPassword      |
        | 123456788        | 123456788          | DENEMETest12345  |
        | 12345678         | 12345678           | DENEMETest12345  |
        | TestNurD         | TestNurD           | DENEMETest12345  |
        | EndeksaTestNur   | EndeksaTestNur     | DENEMETest12345  |
        | !!!@@@###        | !!!@@@###          | DENEMETest12345  |




    @user1
    Scenario Outline: Şifre kurallara uygun güncellendikten  sonra yeni password ile giriş yapılmaya çalışıldığında başarılı  olunmalı(E-mail ile kayıt olunmuş hesapta)
      When Profil sayfasındaki Parola Değiştir butonuna tıklanır
      And  Mevcut Parola alanına "<oldPassword>" ve Yeni Parola alanına "<newPassword>" Yeni Parola Tekrarı alanına "<newConfirmPassword>" girilir
      And  Tamam butonunun enable olduğu doğrulanır ve tıklanır
      Then Kaydedildi mesajı sistemde görülür
      When Hesaptan çıkış yapılır
      And  Eposta ile giriş
      And E-posta alanına "<email>" Parola alanına "<newPassword>" girilir
      And  Giriş Yap butonu tıklanır
      Then Hesaba  "<email>" giriş yaptığı doğrulanır

      Examples:
         | newPassword      |newConfirmPassword | oldPassword      |
         | DENEMETest404565 | DENEMETest404565  | DENEMETest12345  |



    @user4
    Scenario Outline: Şifre değiştikten sonra eski password ile giriş yapılmaya çalışıldığında başarısız olunmalı(E-mail ile kayıt olunmuş hesapta)
      When Profil sayfasındaki Parola Değiştir butonuna tıklanır
      And  Mevcut Parola alanına "<oldPassword>" ve Yeni Parola alanına "<newPassword>" Yeni Parola Tekrarı alanına "<newConfirmPassword>" girilir
      And  Tamam butonunun enable olduğu doğrulanır ve tıklanır
      Then Kaydedildi mesajı sistemde görülür
      When Hesaptan çıkış yapılır
      And  Eposta ile giriş
      And E-posta alanına "<email>" Parola alanına "<oldPassword>" girilir
      And Giriş Yap butonu tıklanır
      Then Hatalı parola veya e-posta adresi uyarısı alındığı doğrulanır

      Examples:
        | newPassword      |newConfirmPassword | oldPassword      |
        | DENEMETest404565 | DENEMETest404565  | DENEMETest12345  |





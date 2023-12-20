CSE3063 TERM PROJECT

# Students 
- username/password
- burak/burakkarayagli
- hakki/hakkikokur
- musa/musaozkan
- efe/efeozgen
- baris/barisgirayakman
- tamer/tamerunal
- okan/okanunal
- baran/baranakman
- ege/egeozgen


# Lecturers

- mustafa/mustafaagaoglu
- muratcan/muratcanganiz
- ali/alifuatkaya

# Advisors

- fatmacorut/fatmacorutergin    ----- hakkikokur, tamerunal, musaozkan, egeozen, okanunal
- betul/betulboz                ----- burakkarayagli, barisakman, efeozgen, baranakman, eylemozgen


# Additional
we have added the libray(jar) files in the directory level. Gson is compulsory. 




İlk iterasyonda temel bir kurs seçme ve onaylama sistemi inşa etmiştik. Bu iterasyonda temel amacımız eklediğimiz özellikler daha kullanıcı dostu haline getirmek ve aynı zamanda gerçekçi bir hale getirmek oldu. 
Öncelike SystemController.java dosyasının içindeki çeşitli methodları object orientet mimarindan daha fazla faydalanmak için ilgili classlara dağıttık. MVC yapısı saglamlaştırmak için öncesinde bir tane menu ve controller classımız varken bunları çeşitlendirip görev çeşitliliklerine göre ayırdık. 

SystemController -> AdvisorCOntroller, LecturerController, StudentController
Menu -> Menu, AdvisorMenu, LecturerMenu, StudentMenu
Course,CourseSection ->Course,SectionInterface, MandatoryCourse, TechnicalElectiveCourse, NonTechnicalCourse

Kodumuz daha module bir hal aldığı için geliştirmeye, ilerleyen zamanlarda yeni özellikler eklemesi daha kolay olacaktır. 

Student class ında ilk iterasyonda temel işlemleri yaparken controllerda kısmen gerçekleştirdiğimiz işlemleri method olarak ekledik. 
- prerequisite işlemleri
- sistemde açılan kursların student ın semester ve transkriptene göre getirilmesi 
- kredi ve kota aşımı gibi durumların kontrol edilmesi 
gibi sistemleri student classına taşıdık. 

Student'a benzer şekilde advisor ve lecturer classlarında da benzer geliştirmeleri yaptık. 

Yeni/Güncellenen Özellikler: 
- Öğrencinin durumunu takip etme(waiting, approved, finished etc.)
- Öğrencinin semester ve transkript bilgisine göre seçebileceği uygun dersleri döndürme
    - checking course semester and student semester
    - checking course quota
    - checking prerequisite list
    - checking time intervals
- Tekil kurs seçimi ve bırakma 
- Advisor tekli kurs onaylama ve red etme
- lecturer mandatory,technical, nontechnical kurs ekleme 
- lecturer derslerine kayıt olan öğrencileri göre 
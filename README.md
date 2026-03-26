# Weather API

OpenWeatherMap API kullanarak şehir bazlı hava durumu verilerini sağlayan bir Spring Boot REST API uygulamasıdır.

## Proje Amacı

Bu proje, harici bir API ile entegrasyon kurmayı ve alınan verileri REST endpoint üzerinden sunmayı göstermek amacıyla geliştirilmiştir.

## Kullanılan Teknolojiler

- Java
- Spring Boot
- Spring Web
- Maven

## Çalıştırma

Projeyi klonladıktan sonra aşağıdaki adımları takip edin:

1. `application.properties` dosyasına API key ekleyin:

```
weather.api.key=YOUR_API_KEY
```

2. Uygulamayı çalıştırın:

```
mvn spring-boot:run
```

## API Kullanımı

### Endpoint

```
GET /api/weather?city={sehir}
```

### Örnek

```
http://localhost:8080/api/weather?city=Istanbul
```

## Örnek Response

```json
{
  "city": "Istanbul",
  "temperature": 20,
  "description": "clear sky"
}
```

## Notlar

- API verileri OpenWeatherMap üzerinden alınmaktadır.
- Proje basit bir katmanlı mimari ile geliştirilmiştir (controller, service, client).

## 👨‍💻 Geliştirici

**Halis Lütfü Bayçöl**
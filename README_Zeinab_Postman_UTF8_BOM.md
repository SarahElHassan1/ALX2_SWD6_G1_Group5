# Postman Testing - Simple Books API

هذا المشروع يحتوي على اختباراتي باستخدام **Postman** لواجهة Simple Books API، كجزء من تعلمي لاختبار واجهات RESTful.

## المحتويات:
- ملف Collection بصيغة JSON
- شروحات للـ Endpoints المستخدمة
- عرض تقديمي بصيغة PowerPoint

---

## 1. إعداد الحساب

للحصول على توكين:
```http
POST /api-clients/
```

```json
{
  "clientName": "Zeinab Osama",
  "clientEmail": "zeinab@example.com"
}
```

---

## 2. الطلبات المنفذة:

### ✅ الحصول على الكتب

```http
GET /books
```

### ✅ طلب شراء كتاب

```http
POST /orders
Headers:
Authorization: Bearer {{token}}
```

Body:

```json
{
  "bookId": 1,
  "customerName": "Zeinab Osama"
}
```

### ✅ عرض كل الطلبات

```http
GET /orders
Headers: Authorization
```

### ✅ تحديث طلب

```http
PATCH /orders/:orderId
```

```json
{
  "customerName": "Zeinab Tester"
}
```

---

## 3. السكربتات المستخدمة في Postman

```javascript
// حفظ التوكين تلقائيًا
let jsonData = pm.response.json();
pm.environment.set("token", jsonData.accessToken);
```

---

## 4. ملفات مرفقة

- `SimpleBooks.postman_collection.json`
- `Postman_Presentation_Zeinab.pptx`
- Screenshots من Postman

---

## من تنفيذ:  
**زينب أسامة**  
QA Tester - Passionate about Automation

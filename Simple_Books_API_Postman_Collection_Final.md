
# Simple Books API - Postman Collection

## 📝 Overview | نظرة عامة
تحتوي هذه المجموعة من اختبارات Postman على اختبارات للـ API الخاص بمكتبة Simple Books، وهي API خيالية لبيع الكتب. تشمل هذه المجموعة عدة نقاط نهاية (Endpoints) للتحقق من حالة الـ API، استرجاع الكتب، إدارة الطلبات، والتحقق من المصادقة.

## 🔧 Setup | الإعداد

### Prerequisites | المتطلبات الأساسية
- [Postman](https://www.postman.com/downloads/) مُثبت على جهازك
- فهم أساسي لاختبار الـ API

### Environment Variables | المتغيرات البيئية
تستخدم هذه المجموعة المتغيرات التالية:
- `baseUrl1`: `https://simple-books-api.glitch.me` (تم إعدادها مسبقًا)
- `token1`, `token2`: رموز المصادقة (يتم تعيينها أثناء الاختبارات)

## 📚 Endpoints | نقاط النهاية

### 1. API Status | حالة الـ API
- **GET /status**  
  يتحقق إذا كان الـ API يعمل بشكل صحيح  
  *Test: يتحقق من أن كود الاستجابة هو 200*

### 2. Book Operations | عمليات الكتب
- **GET /books**  
  يسترجع قائمة الكتب مع فلاتر  
  *Parameters: type (fiction/non-fiction), limit*  
  *Test: يتحقق من أن كود الاستجابة هو 200*

- **GET /books/:bookId**  
  يحصل على تفاصيل كتاب معين  
  *Test: يتحقق من أن الاستجابة تحتوي على اسم المؤلف*

### 3. Authentication | المصادقة
- **POST /api-clients/**  
  يولد رموز الوصول  
  *Body: clientName, clientEmail*  
  *Test: يتم تخزين الرمز في المتغير البيئي*

### 4. Order Management | إدارة الطلبات
- **POST /orders**  
  يقدم طلب كتاب جديد  
  *Headers: Authorization token*  
  *Body: bookId, customerName*  
  *Test: يتحقق من إنشاء الطلب بنجاح (كود الاستجابة 201 أو 202)*

- **GET /orders**  
  يسترجع جميع الطلبات للعميل المصادق عليه  
  *Headers: Authorization token*  
  *Test: يتحقق من تفاصيل الطلب في الاستجابة*

- **PATCH /orders/:orderId**  
  يقوم بتحديث طلب موجود  
  *Headers: Authorization token*  
  *Body: customerName, bookId, quantity*  
  *Test: يتحقق من أن وقت الاستجابة أقل من 500 مللي ثانية*

- **DELETE /orders/:orderId**  
  يحذف طلب  
  *Headers: Authorization token*  
  *Test: يتحقق من أن كود الاستجابة هو 204*

## 🚀 How to Use | كيفية الاستخدام
1. استيراد المجموعة إلى Postman
2. تشغيل الطلبات بشكل متتابع لأن بعضها يعتمد على استجابات سابقة
3. تحقق من نتائج الاختبارات في تبويب "Test Results" في Postman

## 💡 Testing Approach | منهجية الاختبار
- التحقق من كود الاستجابة
- التحقق من محتويات الاستجابة
- التحقق من وقت الاستجابة
- إدارة المتغيرات البيئية
- الاختبارات المعتمدة على البيانات (باستخدام معرّفات الكتب أو الطلبات المختلفة)

## 📂 GitHub Structure | هيكل المشروع على GitHub
```
/simple-books-api-tests/
│── Simple Books.postman_collection.json
│── README.md
│── postman_environment.json (اختياري - إذا كان لديك تصدير للبيئة)
```



*إعداد: زينب أسامة*
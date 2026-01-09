# 🏺 Incan Gold: Bag ADT Game (Java)

Bu proje, popüler **"Incan Gold"** masa oyununun basitleştirilmiş bir Java simülasyonudur. Uygulama, temel olarak **Bag ADT (Torba Soyut Veri Tipi)** yapısının dizi tabanlı ve generic (genel) bir şekilde sıfırdan uygulanmasını temel alır. Oyuncu, antik bir tapınakta hazine ararken tehlikelerle mücadele eder.

---

### 🌟 Oyunun Amacı ve Kuralları

Oyun toplam **5 tur** sürer ve her turda oyuncu kaderini belirlemek için 30 yüzlü bir zar atar.

* 
**Hazineler:** Turquoise (1 puan), Obsidian (5 puan) ve Gold (10 puan) olmak üzere üç tiptir.


* 
**Kartlar:** Toplam 30 adet `QuestCard` bulunur; bunların 15'i **Hazard** (Örn: Örümcek, Yılan, Ateş), 15'i ise **Treasure** kartıdır.


* 
**Kazanma Koşulu:** Oyun sonunda oyuncunun `HazardBox` içindeki tehlike kartı sayısı, `TreasureBox` içindeki hazine kartı sayısından fazlaysa oyuncu kaybeder. Aksi takdirde, hazineler kasaya aktarılır ve puan hesaplanır.



---

### 🏗️ Teknik Mimari ve Veri Yapıları

Projedeki tüm depolama birimleri (Chest, Tent, Box, TreasureBox, HazardBox) birer **Bag** veri yapısıdır.

* 
**IBag Interface:** Torba yapısının temel yeteneklerini (add, remove, contains, getCurrentSize vb.) tanımlar.


* 
**Generic Bag Class:** `IBag` arayüzünü uygulayan, güvenli ve boyutu dinamik olarak değiştirilebilen dizi tabanlı sınıftır.


* 
**Inheritance (Kalıtım):** Hazineler (`Treasure`) ve Kartlar (`QuestCard`) hiyerarşik bir sınıf yapısı ile kurgulanmıştır.



---

### 📂 Sınıf Şeması

| Sınıf Grubu | İçerdiği Sınıflar |
| --- | --- |
| **Varlıklar** | <br>`Player`, `Treasure` (Turquoise, Obsidian, Gold), `QuestCard` |
| **Kart Tipleri** | <br>`HazardCard` (Spider, Mummy, Snake, Fire, Goblin), `TreasureCard` |
| **Depolar** | <br>`Chest`, `Tent`, `Box`, `TreasureBox`, `HazardBox` |
| **Motor** | <br>`Game`, `GameApp` (Main Method) |

---

### 🚀 Çalıştırma Talimatları

1. 
**Bağımlılıklar:** Java Collections Framework kullanımı yasaktır; tüm torba yapıları proje içinde sunulmaktadır.


2. **Derleme:**
```bash
javac GameApp.java
java GameApp

```


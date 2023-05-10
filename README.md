# Dokumentace projektu

### O aplikaci

---

> *Speed Typing Program* je program, kde si uživatel může otestovat své dovednosti ve psaní na klávesnici. Postup hry se postupně ukládá. Aplikace je stále ve vývoji.

### Jak hrát

---

> Při spuštění aplikace se uživatel nachází v hlavní scéně, kde si může přečíst statistiky z minulé hry (celkový počet napsaných slov, průměrné WMP (počet správně napsaných slov za minutu) a celkový počet chyb.

> Dále je zde tlačítko 'Play', které při spuštění zobrazí scénu 'popup-view', kde uživatel zadá své jméno či přezdívku, poté se zahájí test.

> Při stisknutí tlačítka 'Info', se uživateli ukáže scéna s informacemi o aplikaci.

### Použito

---

> Pro vytvoření grafického uživatelského rozhraní v JavaFX byl využit vizuální nástroj [Scene Builder](https://gluonhq.com/products/scenebuilder/).

### Popis jednotlivých kontrolerů, tříd a fxml soborů

---

> Kontroler '*Controller2*' -> propojen s fxml souborem '*popup-view*'. Odkazují na scénu, kde uživatel zadává uživatelské jméno.
>
> Třída '*DataSaving*' -> zde se ukládají data ze hry do souborů (.txt) ve stanoveném formátu a přemisťují se do složky '*data*'.
>
> Třída '*HelloApplication*' -> spuštění samotné aplikace. Je v ní stanovena i ikona aplikace.
>
> Kontroler '*HelloController*' -> propojen se souborem '*hello-view*' -> základní scéna (menu) aplikace.
>
> Kontroler '*RulesController*' -> propojen se souborem '*rules-view*' -> odkazují na pravidla (info) aplikace.
>
> Kontroler '*StartControll*er' (hlavní kontroler) -> propojen se souborem '*start-view*' -> scéna při spuštění testu (nastaveny časovače, ...)

### Zdroje

---

> * Obrázek a šablona aplikace, byla vytvořena autorem.
> * Slova v 'words.txt' souboru, jsou vygenerovány pomocí chatbotu [ChatGPT](https://openai.com/blog/chatgpt).
> * Při vymýšlení nápadu na projekt děkuji spolužačce [Kláře](https://github.com/ThemSatan).

### Progres

> Zde se nachází postupná práce na projektu.

---

> * 17.04.2023 - rozhodnutí tématu projektu, založení projektu a instalace [Scene Builderu](https://gluonhq.com/scenebuilder/).
> * 18.04.2023 - rozložení projektu na úkoly. Přidány první dvě scény 'hello-view' a 'popup-view'. Nastavení samotného designu scén (tlačítka, labely, ...). Vytvoření souboru 'words.txt', ve kterém jsou vygenerovány slova. Nastaveno logo *stage*. Propojení kontrolerů s fxml soubory. Vytvoření souboru 'username.txt'.
> * 29.04.2023 - opraveny 'warning' upozornění ohledně použití špatné verze JavaFX API. Přidání proměnných a labelů WMP, accuracy a seconds -> propojení s kontrolery a naprogramování jejich funkčnosti.
> * 30.04.2023 - přidání 'Keystrokes' (úhozů). Přidání scény 'rules-view'.
> * 09.05.2023 - konečná úprava vizuálu scén. Dokončená scéna 'rules-view'. Upraveno: místo textu "time is up!" se vypíšou i samotné údaje (WMP, ...).
> * 10.05.2023 - vytvoření README.md. Upraveno logo *stage* na finální verzi. Přidána hotová dokumentace. Upravení zbytečných upozornění a přehlednosti kódu.

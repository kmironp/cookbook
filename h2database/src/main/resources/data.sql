INSERT INTO Users (Username, Password, Email) VALUES
    ('Teszt', '123456', 'teszt@gmail.com'),
    ('Jani', 'Jani02', 'jani02@email.com'),
    ('Zsuzsika', 'asd', 'marika1941@gmail.com')
;

INSERT INTO Book (Name_Of_Food, Type, Preparation_Time, Calorie_Content) VALUES
    ('Tojás_leves', 'Leves', '15 perc', '808/4adag'),
    ('Lasagne', 'Főétel', '45 perc', '2312/4adag'),
    ('Mignon', 'Desszert', '48 perc', '1972/4adag')
;

INSERT INTO Cook (Name_Of_Food, Sensitivity_Chart, Ingredients, Preparation) VALUES
    ('Tojás_leves', 'Glutént és Tojást tartalmaz', '4 adaghoz: 2.7 evőkanál finomliszt, 1.3 kávéskanál fűszerpaprika, 1.3 teáskanál őrölt fűszerkömény (ízlés szerint), 2.7 gerezd fokhagyma (aprított), 10.7 dl víz, 1.3 kávéskanál só (ízlés szerint), 5.3 db tojás, 4 ek napraforgó olaj', 'A lisztet kevés olajon megpirítjuk, majd megszórjuk pirospaprikával és jó sok köménnyel. Beletesszük a zúzott fokhagymákat, és kicsit még pirítjuk. Felöntjük vízzel, sózzuk, és felforraljuk. Forrás után én a tojások számát megfelezve, kettőt felverve belecsurgatok, kettőt pedig egészben teszek bele. Kb. 1-2 perc múlva, amint az egész tojások megfőttek, készen is vagyunk. Érdemes a só és a kömény kellő mennyisége miatt a végén még utánakóstolni.'),
    ('Lasagne', 'Laktózt, glutént és tejet tartalmaz', '4 adaghoz: 166.7 g lasagne tészta (főzés nélküli), 3.3 dl tej, 3.3 dkg vaj, 2 ek finomliszt, 1.3 késhegynyi szerecsendió (frissen reszelt), 3.3 levél bazsalikom, 2.7 ek olívaolaj (2-2 ek.), 400 g konzerv paradicsom (hámozott, kockázott), 266.7 g darált marhahús, 133.3 g parmezán sajt, só ízlés szerint, bors ízlés szerint, 2 db babérlevél', 'A húst 2 ek olívaolajon megfuttatjuk. Sózzuk, borsozzuk, hozzátesszük a babérlevelet, majd 10-12 percig kis lángon főzzük. Közben 2 ek olívaolajon főzni kezdjük a paradicsomot. Kb. 10-15 percig rotyogtatjuk. A húst a szósszal összeöntjük, és újabb 15 percig pöfögtetjük kis lángon. Az utolsó 3 percben hozzáadjuk a felvágott bazsalikomot. Közben a vajat megolvasztjuk, hozzátesszük a lisztet, kis lángon elkeverjük, és lassan, folyamatos kevergetés mellett hozzáöntjük a tejet. Sózzuk, borsozzuk, hozzáreszeljük a szerecsendiót, majd folyamatosan kevergetve sűrűre főzzük. Hozzáadjuk a reszelt parmezán felét. Elzárjuk alatta és a paradicsomos szósz alatt is a gázt. Egy 25x35-ös tepsit kivajazunk, és leteszünk egy adag főzést nem igénylő lasagne tésztát (barilla). Ráteszünk egy adag húsos ragut, majd ismét tésztát. Addig rétegezzük, amíg a hozzávalók elfogynak. Az utolsó adag tésztára a besamel kerül. A tetejére tegyük a parmezánt, majd toljuk 180 fokra előmelegített sütőbe. Süssük 20 percig, majd még 10 percig hagyjuk állni, mielőtt felvágjuk. Sütésfoka: 180C kb 20 percig.'),
    ('Mignon', 'Desszert', '4 adaghoz: A tésztához: 2.7 dkg étcsokoládé, 2.7 dkg vaj (vagy sütőmargarin), 1.3 db tojás, 2.7 dkg barna cukor, 2 dkg finomliszt, 0.3 csipet só, 0.3 csipet fahéj - A krémhez: 0.5 dl főzőtejszín (vagy tej), 8.7 dkg cukor (kristály), 8 dkg vaj (vagy margarin), 2.3 dkg cukrozatlan kakaópor - A mázhoz: 10 dkg cukorfondant, 1 csepp ételfesték (barna vagy kakaópor)', 'Először a csokoládékrémet készítjük el. Ehhez a tejszínt egy lábasban a cukorral, kevergetve 2-3 percig forraljuk. A vajat (margarint) beledobjuk, ha elolvadt benne, a kakaót is beleszitáljuk. Jól elkeverjük, a tűzről lehúzzuk, hűlni hagyjuk, majd hűtőszekrénybe tesszük pár órára vagy akár egész éjszakára. Ezután elektromos habverővel jó habosra keverjük. A tésztához a csokoládét a vajjal együtt felolvasztjuk, majd hűlni hagyjuk. A tojásfehérjét kemény habbá verjük, a vége felé a cukrot is kanalanként beledolgozzuk. Egyesével hozzáadjuk a tojások sárgáját, majd belecsurgatjuk a még éppen híg, de semmi esetre sem meleg - mert akkor a hab összeesik - csokis vajat. A lisztet a sóval és a fahéjjal összefogatjuk, az előzőekre szitáljuk, óvatosan összeforgatjuk. Egy nagy tepsibe a masszát egyenletesen elkenjük. Előmelegített sütőben, a közepesnél kicsit kisebb lánggal kb. 18 percig sütjük, de vigyázzunk nehogy kiszáradjon. Amikor a tészta kihűlt, a széleit levágva 6 egyenletes lapra vágjuk. Hármat-hármat a felhabosított csokoládékrémmel megtöltjük. 1-2 órára hűtőbe rakjuk. Tetszés szerinti nagyságúra szeleteljük őket, majd a felolvasztott fondánttal áthúzzuk őket. Olvasztott csokoládéval díszíthetjük. Sütés hőfoka: 170 °C kb 18 percig.')
;

INSERT INTO Favourite_Foods (Username, Foods) VALUES
    ('Teszt', 'Tojás_leves'),
    ('Teszt', 'Mignon'),
    ('Jani', 'Mignon'),
    ('Zsuzsika', 'Lasagne')
;

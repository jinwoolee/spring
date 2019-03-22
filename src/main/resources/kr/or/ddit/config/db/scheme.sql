
  CREATE TABLE USERS 
   (	USERID VARCHAR2(20 BYTE), 
	USERNM VARCHAR2(20 BYTE), 
	PASS VARCHAR2(100 BYTE), 
	REG_DT DATE, 
	ALIAS VARCHAR2(50 BYTE), 
	ADDR1 VARCHAR2(50 BYTE), 
	ADDR2 VARCHAR2(50 BYTE), 
	ZIPCODE VARCHAR2(5 BYTE), 
	FILENAME VARCHAR2(50 BYTE), 
	REALFILENAME VARCHAR2(200 BYTE), 
	 CONSTRAINT PK_USER PRIMARY KEY (USERID)
    );
  

   COMMENT ON COLUMN USERS.USERID IS '사용자 아이디';
   COMMENT ON COLUMN USERS.USERNM IS '사용자 이름';
   COMMENT ON COLUMN USERS.PASS IS '비밀번호';
   COMMENT ON COLUMN USERS.REG_DT IS '사용자 등록일';
   COMMENT ON COLUMN USERS.ALIAS IS '별명';
   COMMENT ON COLUMN USERS.ADDR1 IS '주소';
   COMMENT ON COLUMN USERS.ADDR2 IS '상세주소';
   COMMENT ON COLUMN USERS.ZIPCODE IS '우편번호';
   COMMENT ON COLUMN USERS.FILENAME IS '업로드파일명';
   COMMENT ON COLUMN USERS.REALFILENAME IS '실제파일경로';
   COMMENT ON TABLE USERS  IS '사용자';

  

  
  
  insert into users values('brown', '브라운', 'c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44', '19/01/28', '', '', '', '', 'brown.png', 'D:\picture\aa231396-5521-4386-b320-09aedf60cde0');
insert into users values('cony', '코니', '55525cd5e74f52ef9e686b812f616b5891bda924f26450113b3f6ebd6adb5c', '19/01/28', '', '', '', '', 'cony.png', 'D:\picture\535d2599-4fb5-4fce-a514-11320de99aec');
insert into users values('sally', '샐리', 'c96de0c53a6194aceefbf83121e5b7dfb9d675dee1821d6da438dc3ae3e1ef55', '19/01/28', '', '', '', '', 'sally.png', 'D:\picture\11fb49e3-f953-496d-8109-f2b7853b994d');
insert into users values('james', '제임스', 'b097f022d7879a164ea13dd63719e7a2af70c372d9139fc1d6443c6884e2f851', '19/01/28', '', '', '', '', 'james.png', 'D:\picture\d52bad73-596b-4055-a7ed-3392adaa8f95');
insert into users values('moon', '문', '7deff5c6fea2a1683b983bc5969afa759d13c5dc0d6dbd02c6f5bd091e06c', '19/01/28', '', '', '', '', 'moon.png', 'D:\picture\957cadae-ead3-4763-90d6-53c53951d8fe');
insert into users values('userId2', 'userNm2', '711b06590e7dfc744e9ded61eafa1bf63712eee87f17f79ffed139ef7863b', '19/01/27', '', '', '', '', '', '');
insert into users values('userId3', 'userNm3', 'd6cc8aeb2597b641f6619477da715aebf589a6179e949bfd175c7f3ce13ebd4', '19/01/26', '', '', '', '', '', '');
insert into users values('userId4', 'userNm4', 'bbd4add4fad4c3e36d41e890a1bdf453ea40dcec2b56ddb8e31eaa794b2b7732', '19/01/25', '', '', '', '', '', '');
insert into users values('userId5', 'userNm5', '6b5872874933ff8f48f435afb232b61cdffa9fc699ff4f89620caf591437c', '19/01/24', '', '', '', '', '', '');
insert into users values('userId6', 'userNm6', 'dbaa195daefd39d8352b973a48f29029e76746f5149e41bf37415c7fb348d6c', '19/01/23', '', '', '', '', '', '');
insert into users values('userId7', 'userNm7', '649b63e27db2b21d50690d9c1e649a73ef99d7650bde9cf5e034be8d7a65cf', '19/01/22', '', '', '', '', '', '');
insert into users values('userId8', 'userNm8', '4a8138b27e942fc5677b6d18236984bea66ceed1b75a2af4e4a3452feb0593c', '19/01/21', '', '', '', '', '', '');
insert into users values('userId9', 'userNm9', '6ccd4c789342d37de61f6a185dbe9d07f53dc1ed6ff348cd49ede261a09', '19/01/20', '', '', '', '', '', '');
insert into users values('userId10', 'userNm10', '1824fc1d7806ada7881f45149616b15fc289c44b62517b7a33b1a993e7cb', '19/01/19', '', '', '', '', '', '');
insert into users values('userId11', 'userNm11', '27a6942cb18f821665723df594571289c82a3d589338606445f7b43fb63435', '19/01/18', '', '', '', '', '', '');
insert into users values('userId12', 'userNm12', 'c5a44340a88afcb4e280e1a5b4464ec1c78b541d564e59282c8b51ff443e8366', '19/01/17', '', '', '', '', '', '');
insert into users values('userId13', 'userNm13', 'c379d5b9dca04751606324a3c3ff538cbd5dd7dd8e256cf9b6c1189781d', '19/01/16', '', '', '', '', '', '');
insert into users values('userId14', 'userNm14', 'f14d85c449e74471266e2187cb9c3b1b2e36c0d9923cb75c5a2fcd13b1787e51', '19/01/15', '', '', '', '', '', '');
insert into users values('userId15', 'userNm15', 'e4557c1f8d3fc8e273cee5a48a6a9892c4e552c963794fe6d207cb6e1ef156c', '19/01/14', '', '', '', '', '', '');
insert into users values('userId16', 'userNm16', 'a0db65e8479a2882e9316a23b48c3f389c6b4ceaa858527e9bd3f28cca51e90', '19/01/13', '', '', '', '', '', '');
insert into users values('userId17', 'userNm17', '20367268df59e5a5741e732075bb9b6ed61acc14e443d31edc874f138931', '19/01/12', '', '', '', '', '', '');
insert into users values('userId18', 'userNm18', 'f1197ed9a1df531b59cd18b05c428218eb7f8658cb59bbc9bc76ff42a3a20', '19/01/11', '', '', '', '', '', '');
insert into users values('userId19', 'userNm19', '7069a09992e2fa17d32ecb4537d887da1d146390eaa9adadfd9942a4455fa54', '19/01/10', '', '', '', '', '', '');
insert into users values('userId20', 'userNm20', '8e60e5d0ff3266d9e21577dccbba97b173787c8a1cc460cdacd6eb2717216', '19/01/09', '', '', '', '', '', '');
insert into users values('userId21', 'userNm21', '13c415fe4dd9cec91f866f4edc19c5e5647439692b168ebf28e973fc1cf43f8', '19/01/08', '', '', '', '', '', '');
insert into users values('userId22', 'userNm22', '6ca97615e5b8dc578ef1303839ac972146d4adb5f4b85a34c47e721c4559be', '19/01/07', '', '', '', '', '', '');
insert into users values('userId23', 'userNm23', '9d55658c44ec659faa86ae17d59abe765ce78353c3f7aa48b679ea56c7a5f35', '19/01/06', '', '', '', '', '', '');
insert into users values('userId24', 'userNm24', '9b29eab83de4a1a124bbb66b77dacc8ed2710ab1af1f194c3d99b55798b83a7', '19/01/05', '', '', '', '', '', '');
insert into users values('userId25', 'userNm25', '217cfdc89eecda21e1b1d388b4bf66a144233ee3fcfae1be0f674488b6cba3e', '19/01/04', '', '', '', '', '', '');
insert into users values('userId26', 'userNm26', '33a21568bab0cfc4752223621c9bde487b387631bbf299cee79cf3dabf64ee', '19/01/03', '', '', '', '', '', '');
insert into users values('userId27', 'userNm27', 'd8d83dcb77b1510d73cb422fa493fc7eaadae1f5b4e45c3689c9c8fd7a87d', '19/01/02', '', '', '', '', '', '');
insert into users values('userId28', 'userNm28', '428d76d73961db8f53641b2cc32222ee5e82f1945ccbf573ce3dbde838bd', '19/01/01', '', '', '', '', '', '');
insert into users values('userId29', 'userNm29', 'a54a95b7a9c8787ea868a543f432714652dfc64739e65585419966629e7df60', '18/12/31', '', '', '', '', '', '');
insert into users values('userId30', 'userNm30', '24136504c2894f72da0750a8829242ef40595cc58b9495c96d9c257fcb5', '18/12/30', '', '', '', '', '', '');
insert into users values('userId31', 'userNm31', 'eaba3dc2c778db374a86b5eaf65b7a7b48656e9ecd8d26821fd4a68fcc5829', '18/12/29', '', '', '', '', '', '');
insert into users values('userId32', 'userNm32', 'eb3263c560faf1501196599b2bae8f79bc9b057263b846fbcf142458efdadc5', '18/12/28', '', '', '', '', '', '');
insert into users values('userId33', 'userNm33', '920f98deb7ffe43561269b77bab5ee5d2a9f487ce9d6749da951d5cb781', '18/12/27', '', '', '', '', '', '');
insert into users values('userId34', 'userNm34', 'b8412ff46dff62e91ec38b4ba7809fc5eed592e06f956129cf2cf8d78d17a4', '18/12/26', '', '', '', '', '', '');
insert into users values('userId35', 'userNm35', 'a827c0dca978d6376378397427fb4f46fc874b5a8835de8f7e4d049dda80aa', '18/12/25', '', '', '', '', '', '');
insert into users values('userId36', 'userNm36', 'b2d645d24cafe4579085b625e455624ea25369d37bdbe313ca90248d48dd', '18/12/24', '', '', '', '', '', '');
insert into users values('userId37', 'userNm37', '233c6221932437dde01228ea375098b38e21d12db0bb523b6dcdb1e0a8154f9', '18/12/23', '', '', '', '', '', '');
insert into users values('userId38', 'userNm38', '944717c9a11085ef75e76fd2b1345111b069c1d2e81184b2cc961eff9cb753e2', '18/12/22', '', '', '', '', '', '');
insert into users values('userId39', 'userNm39', '76ea074c8d31913e378c1746fd2c132ca91ad95d4a9c9d183928eaf5bf88', '18/12/21', '', '', '', '', '', '');
insert into users values('userId40', 'userNm40', 'add03624515fa822dda51cbdbf82e4fd4e9d78166d9d9a62f722f133858fd5', '18/12/20', '', '', '', '', '', '');
insert into users values('userId41', 'userNm41', '42127eb34dfed8145642f45485a5bbad2fbdb41fea788d1da90a37ba1e88c20', '18/12/19', '', '', '', '', '', '');
insert into users values('userId42', 'userNm42', '4158fdeaf27e5f106668fe47b4cc9bda284f3cacf3e5b884251ee9adb2241a', '18/12/18', '', '', '', '', '', '');
insert into users values('userId43', 'userNm43', 'efcb5947debef158b5ef924e5a0b79a3f981cbcb554759671234ed3eac14', '18/12/17', '', '', '', '', '', '');
insert into users values('userId44', 'userNm44', '1cab8de42febddbe4fbc93d19f674baeddc1e4e67d8b238109232f7b084bd', '18/12/16', '', '', '', '', '', '');
insert into users values('userId45', 'userNm45', '35d4a5f480fdb4b662c28d5cc927666a48278bacb3abdaaf5d1f461e8e5a', '18/12/15', '', '', '', '', '', '');
insert into users values('userId46', 'userNm46', 'e3ad228aeff4e3ebbc0232dceb18ed2c9912fa1233d4b51450ae9385331e1', '18/12/14', '', '', '', '', '', '');
insert into users values('userId47', 'userNm47', '50d74e7b805fec21a82ea7826c9595aa1425462c62175eddb26d125ea57445f', '18/12/13', '', '', '', '', '', '');
insert into users values('userId48', 'userNm48', 'bfa95c5d2b87f1679412a6c1f1395c6fcf92a4cd8e6415e10595217f206fb1', '18/12/12', '', '', '', '', '', '');
insert into users values('userId49', 'userNm49', 'ab255fb8d8c14ae965478be4d06648a7aea89852a6bcaef296561a4c72f68d', '18/12/11', '', '', '', '', '', '');
insert into users values('userId50', 'userNm50', '3c9276dae1bc2e10af8033a0dd80fea1dc9c4bb9ee1d6d4f06d191a9a462310', '18/12/10', '', '', '', '', '', '');
insert into users values('userId51', 'userNm51', '908ad65d36abdaa422203b473994593676e5863b2e2ca11108a2d01eb1842', '18/12/09', '', '', '', '', '', '');
insert into users values('userId52', 'userNm52', 'e93ef362f5bddd9a065602b73ee6c7bd74bfa3d58b4ffd8ea4a9896cbd387c8', '18/12/08', '', '', '', '', '', '');
insert into users values('userId53', 'userNm53', '3856988163aac6528dc9e459cf278d6e7fbaafb5f4ebd2f13dffacf36763a2a', '18/12/07', '', '', '', '', '', '');
insert into users values('userId54', 'userNm54', '30937dcfb95513961e8d7459c303f3daa262e4492460cb213354a4aa438cf9', '18/12/06', '', '', '', '', '', '');
insert into users values('userId55', 'userNm55', 'a74f71cfc913bb7442e4a5d41e4ead19779e1bef8ee68e0e7d4234bbddd63', '18/12/05', '', '', '', '', '', '');
insert into users values('userId56', 'userNm56', 'd27ea3621023fe57e7247a506751e6d1a4d47f8ca8b9dc8704843017273da5', '18/12/04', '', '', '', '', '', '');
insert into users values('userId57', 'userNm57', '5d2a7e27b2e09e10163a9807320eaa615a477252fae1096c2f4c0821e759fca', '18/12/03', '', '', '', '', '', '');
insert into users values('userId58', 'userNm58', '64f34dbec42411eb588e7e1edf1199e6ce57f4cb981197aeb87b6db1935d666', '18/12/02', '', '', '', '', '', '');
insert into users values('userId59', 'userNm59', '56d56a19c3c3aa327ebd7bf7e9c53ae86e8cdc9a635724a4e8b44f2dd896a85', '18/12/01', '', '', '', '', '', '');
insert into users values('userId60', 'userNm60', 'a59f1e369a1b5283a7bf4f9c1f81c11966389605f813ef8ba7dbd5b7e05217', '18/11/30', '', '', '', '', '', '');
insert into users values('userId61', 'userNm61', '57c412fa1eb93e3c68b9722f1a6011a2882cc42bb29a64655139418f8ad2be5', '18/11/29', '', '', '', '', '', '');
insert into users values('userId62', 'userNm62', 'fb90b528a9b7b0dfdf1f8457d77c9a48a67d7ebe82c0b18f3c419c212ba0a347', '18/11/28', '', '', '', '', '', '');
insert into users values('userId63', 'userNm63', '2bea8a4a238aa9fdc787e2dfa6236282e7adc5644163e57865e9e926c8a2f01c', '18/11/27', '', '', '', '', '', '');
insert into users values('userId66', 'userNm66', 'bf6eaa1ca5d3f3bd42ff1a893763be6c3a4bbbb995951784bdca60337d88', '18/11/24', '', '', '', '', '', '');
insert into users values('userId69', 'userNm69', '458221fd42ef2f32d7ee663b91d426da541616496dffb1933105d2f412253b', '18/11/21', '', '', '', '', '', '');
insert into users values('userId72', 'userNm72', '2bb4ba8163bec52a89acd9a6dfc09bcf382eba63b18d27ed46c5edfdfc70db', '18/11/18', '', '', '', '', '', '');
insert into users values('userId75', 'userNm75', '9d14249de1687bc6d825607732d014c1de6fdbd9a0e4b1dfb04659f0278253f8', '18/11/15', '', '', '', '', '', '');
insert into users values('userId78', 'userNm78', 'c946e84e83f5d7c936b9fbe27fa63102090aa54b33a55ff3eccdb3258e7ecb', '18/11/12', '', '', '', '', '', '');
insert into users values('userId82', 'userNm82', 'f34e9b4091fd10a2d2c96aca8ffc1fa0483e5f208828becc624dc8835f63d1', '18/11/08', '', '', '', '', '', '');
insert into users values('userId85', 'userNm85', '683add4dcb4189f33afc38d6a3d32fc79de321e911689284dac7b8c9f5a9a5dc', '18/11/05', '', '', '', '', '', '');
insert into users values('userId88', 'userNm88', '4c3bdcffd79eac718aa1a63ac9aca4ffe8597100763948cc94e9aa5615f4', '18/11/02', '', '', '', '', '', '');
insert into users values('userId91', 'userNm91', 'f88a41d781e6d3956afb968dcaf2563723b4b6686c1bc7f195e814a9bbb449bd', '18/10/30', '', '', '', '', '', '');
insert into users values('userId94', 'userNm94', 'fb385dfb754423a7525253f150aec19933bde91eb2c9141e589bc64c43ad9', '18/10/27', '', '', '', '', '', '');
insert into users values('userId97', 'userNm97', 'a28ec5e2cb7b4421b0b17f41defba8fa47b9b0da9c13424b41ef30bc8fd62e2b', '18/10/24', '', '', '', '', '', '');
insert into users values('userId100', 'userNm100', '676a445aa526388ed3f58ac003b2c2d4d1ee13a8edb96cbd4f3b0ba951751', '18/10/21', '', '', '', '', '', '');
insert into users values('ljw', 'jinwoo22', 'db68f360cf635c6739fa3bcb895ff553b1831c16a182d47614cea0277fc127', '19/02/11', 'jw', '대전시 중국 대흥로 76', '2층 ddit', '34942', '', '');
insert into users values('ljw3', 'ljw', 'f72cc655947b97741c4b3dbc94b448b2c71e72e925d71d409f9511a02828', '19/02/11', 'ljw', '경기 성남시 분당구 판교역로 235', '123123', '13494', '', '');
insert into users values('ljw2', 'dfdf', '2939e1a2d1fee4b253b704982fc1c9a4581c8f35ba15f112bd3ca4ad7b898d0', '19/02/11', 'dfsdf', '경기 성남시 분당구 판교역로 235', 'dfdf', '13494', '', '');
insert into users values('ljw4', 'ljw4', '2a8cbebe45b72347c6bbb959a9586b62097272b3b955e8eabf5d1878559d6', '19/02/11', 'ljw4', '대전 동구 대흥로 194', 'ljw4', '34631', '', '');
insert into users values('userId64', 'userNm64', '8b78cfb849feb035e8d5d0261b55c7823f72b4e89a4fa43ea86caf915a9313b', '18/11/26', '', '', '', '', '', '');
insert into users values('test', 'test', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6caa1e', '19/03/11', 'test', '대전 중구 대흥로 76', '123', '34942', 'brown.png', 'd:\picture\2fe5e06f-d6a2-41f4-8ecb-428155bac8aa');
insert into users values('sally_new', 'sally_new', 'a676f63b867695b6f81186af85038305ae71250839f8a95fa1762a5eec75e0', '19/02/13', 'sally_new', '대전 중구 대흥로 76', 'sally_new2', '34942', 'cony.png', 'd:\picture\1e2458d3-c6ea-4f3f-bd51-44594e45cf13');
insert into users values('userId65', 'userNm65', '427694a28b5c6181ed6f49d5e5620c3dab335d5486b15a5859be4c90c4cd3a', '18/11/25', '', '', '', '', '', '');
insert into users values('userId67', 'userNm67', '2892a95bca3d5cb4d31655c254d67e46fb67f92699fe42332a52a9ea7a8f1c', '18/11/23', '', '', '', '', '', '');
insert into users values('userId68', 'userNm68', '9e40987d9359c327ec13f145d2e8f3e059c08b90f080c0d49abae96d83d9c8', '18/11/22', '', '', '', '', '', '');
insert into users values('userId70', 'userNm70', '6ca4cb1397e7e39eb1e1ad3eb8a46bc217b72af2daae6393adf899a50b3e8', '18/11/20', '', '', '', '', '', '');
insert into users values('userId71', 'userNm71', 'bcfa12c252b71eda47f65327f36c2c48d7d070a0be2c3a53f6a7e6acf1eb3', '18/11/19', '', '', '', '', '', '');
insert into users values('userId73', 'userNm73', '7e3b97b7d82c9399279b8da2c737ea509f1ac5f65636b692811cf1ba1e65da88', '18/11/17', '', '', '', '', '', '');
insert into users values('userId74', 'userNm74', 'a22de1e16d53d6b266ec93b49f4499ec9679a49aacf9313d95f936e168ba332', '18/11/16', '', '', '', '', '', '');
insert into users values('userId76', 'userNm76', '56fddb9132c3bb605a7898559d1cce8a2c585e2273279b03a61f4beff15fa', '18/11/14', '', '', '', '', '', '');
insert into users values('userId77', 'userNm77', '76df7bede0ce7ccaaefbf11dfa2bc824dd99a45025f0d0989f78ffecd7582242', '18/11/13', '', '', '', '', '', '');
insert into users values('userId79', 'userNm79', '33b2895c4c1a8bda3e244d6273a8fa0d36560b9c28088b660b72a1aa42948', '18/11/11', '', '', '', '', '', '');
insert into users values('userId80', 'userNm80', '56dd1c1cdd67cd04a14ea48f7f1d1a9e23b7d274f81a6a5afe2f3ae62c096de', '18/11/10', '', '', '', '', '', '');
insert into users values('userId81', 'userNm81', 'c58b8542964878352decb32b9b9b816c73fe4f69314b9b7398619edb8565a', '18/11/09', '', '', '', '', '', '');
insert into users values('userId83', 'userNm83', '652c7daf1212be3d8293481aa2ea648e6a553db9aaa81ca0c14b9772395b2', '18/11/07', '', '', '', '', '', '');
insert into users values('userId84', 'userNm84', '1ee6eafeceb2ed78bddefc4bad3a6fd79e257dc1b6c142d49374bdac138d93', '18/11/06', '', '', '', '', '', '');
insert into users values('userId86', 'userNm86', '1a6cb351ba612f964d1a118af979a3021a3622f24fcbda9bd4c732a33f8c938', '18/11/04', '', '', '', '', '', '');
insert into users values('userId87', 'userNm87', '5a7c5ec98773c5ba5a9623cc7b1e837a95d48ac73fc580d6b8d0dd8f852a31', '18/11/03', '', '', '', '', '', '');
insert into users values('userId89', 'userNm89', '1e3f2f8c3f1379348d877288243b66633c61f5c57f7663de896181f74f4658b', '18/11/01', '', '', '', '', '', '');
insert into users values('userId90', 'userNm90', '5fac5fd8635f8f62a85e71601677739e92498976dd839315a1afaa1c050219', '18/10/31', '', '', '', '', '', '');
insert into users values('userId92', 'userNm92', '1ba35cd5ddba2ca9b9660d3414064a393bcd1064b137f3a06938b1c63aa01c', '18/10/29', '', '', '', '', '', '');
insert into users values('userId93', 'userNm93', '242a1fd0efa79834f489bc9fd34132385ab87f8f7bffcf6bb8f26db5c93c3c5', '18/10/28', '', '', '', '', '', '');
insert into users values('userId95', 'userNm95', '4f2ec181b43a82f7a9a6927d3a5ec27060c582561f1ec68128c1ca2e630e5a', '18/10/26', '', '', '', '', '', '');
insert into users values('userId96', 'userNm96', '856e351aeacce831ff47b582776dc20c71b6e3eb6b17e4ee74e03f9c2523a1', '18/10/25', '', '', '', '', '', '');
insert into users values('userId98', 'userNm98', '7f52bc199b7827482682b1dd8ec113677d4e962409932c723638f1e1fdc962', '18/10/23', '', '', '', '', '', '');
insert into users values('userId99', 'userNm99', '3d156f5f375e211bcc252c1c57c3927d949d6633f037c0325ead427cab11', '18/10/22', '', '', '', '', '', '');
insert into users values('brown10', '브라운', '757959532a82924c86c8f1245fa4997db06677d425f1ebcc8b525151751e9cd', '19/03/04', '브라운566778899', '대전 중구 대흥로 76', '영민빌딩2층', '34942', 'brown.png', 'd:\picture\735905c8-5160-45a2-8088-5af5c1e45edf');
insert into users values('aass123', 'aaasss', 'a1802d9168ff46e1de78cd27dde0afbde99a8e69143cd6147632738bedd9a0d6', '19/03/04', 'aaasss', '대전 중구 대흥로 7', '어렵다', '34944', '', '');
insert into users values('sallyTest', '테스트', '13d249f2cb4127b4cfa75786685278793f814ded3c587fe5889e889a7a9f6c', '19/03/05', '별명', '대전 중구 대흥로 76', '2층 ddit', '34942', 'sally.png', 'd:\picture\3eddbe10-b8a6-42b9-b28b-b80a4efb4b10');
insert into users values('userId1', '샐리테스트', '13d249f2cb4127b4cfa75786685278793f814ded3c587fe5889e889a7a9f6c', '19/01/28', '병아리', '대전시 중구 대흥로 76', '2층 DDIT', '34942', 'moon.png', 'd:\picture\b9a6f872-48dc-451b-9ac1-c297bfdf1476');

commit;

create table ranger(
    id varchar2(50),
	name varchar2(50));    
    

create table rangerDept (
    deptcd varchar2(50),
	deptNm varchar2(50)
);
    
    
    
create table no_exists_table(
id number
);
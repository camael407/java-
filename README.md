# java-
------- 로또번호 랜덤 추출기-------------

출처 : https://yeev.tistory.com/6

I.계획
1. swing을 이용하여 버튼 추가
2. 버튼 외곽선 없애기
3. 추가 된 버튼을 누를 시 textarea, label 모두 리셋처리
4. hashset을 이용하여 중복 처리하기
5. label에 이미지 추가해보기
6. textarea에 내용을 가운데정렬, 자동 정렬 해보기
7. jar 파일 만들어서 exe파일 만들어 실행해 보기

II. 성공한 부분
1. swing을 이용하여 버튼 추가
2. 추가 된 버튼을 누를 시 textarea, label 모두 리셋처리
3. label에 이미지 추가해보기
4. 버튼 외곽선 없애기

III. 한계점
1. textarea의 내부에 중앙 정렬불가
* textpane으로 변경하여 처리할 예정.
* label로 묶어서 처리해볼 예정.  
2. hashset을 이용하여 중복처리 할 예정이었으나 중복이 발견됨.
* 22/10/31 17:01 임시해결 (arraylist로 다시 받아서 if문으로 중복처리)  
3. 화면 미출력 버그 발생
* 22/11/01 08:51 해결완료 ( setVisible(true); 위치에 따른 에러)  
4. 상대경로에 있는 파일 불러오지 못함
* 22/10/31 23:50 해결완료 (lotto폴더 내부에 img폴더를 만들어서 해결)  
5. exe파일 실행불가
* jsmooth와 launch4j를 이용하여 만들긴 하였으나 java를 찾지 못하고 jni를 찾지 못하는 에러발생

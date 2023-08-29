![0829230118384117](https://github.com/boradorying/appleMarket/assets/136980408/46904767-0854-4d98-a88f-f038322964f5)# 프로젝트 제목

**당근마켓 클론코딩: apple_market**

## 프로젝트 설명 및 목적

당근마켓을 클론코딩함으로써 좋아요,삭제,리싸이클러뷰,다양한 애니메이션을 구현할 수 있다

## 설명

### 1. 메인페이지 (리싸이클러뷰 활용) & 디테일페이지(리싸이클러뷰의 아이템)

![0829224518800989](https://github.com/boradorying/appleMarket/assets/136980408/ec62037b-326e-4356-9fdb-f6bf1ca5d269)

-RecyclerView 사용함으로써 아이템들을 스크롤 가능하게 정렬
-RecyclerView의 OnItemLongClickListener를 사용함으로써 아이템을 클릭했을 시 아이템 상세페이지로 이동


### 2. 디테일페이지에서 하트이모티콘 클릭시 Fill하트로 변경 & snakbar메시지 띄우기


![0829224914125828](https://github.com/boradorying/appleMarket/assets/136980408/2f209244-4e71-4f81-afb7-d58d1adc896b)
-Detail페이지에서 하트 버튼클릭시 꽉찬 하트로 변경 boolean 이용
-snackbar 메시지 띄우면서 하트 클릭시 '관심목록 추가됨' 띄우기 showSnackBarMessage 사용

### 3. 디테일페이지에서 하트이모티콘 클릭시 메인페이지에 있는 해당 아이템 like 카운트+1 되고 하트이티콘도 마찬가지로 fill 하트로 변경

![0829225217574502](https://github.com/boradorying/appleMarket/assets/136980408/786a1cf6-57c8-4b6b-aa66-96575bcbce05)
-startActivityForResult 이용해서 데이터 결과 전달주고 받기 사용 (다음에는 registerforactivityresult 이용해보기)
-boolean을 이용해서 like++ 도 같이 전달 


### 4. 메인페이지에서 하트이모티콘이 색칠된 아이템의 디테일 페이지로 돌아가면 꽉찬 하트로 되어있을 시 클릭 하면 빈 하트로 변경 ,snackbar로'관심목록 제거됨'띄우고,해당아이템의 라이크 카운트 -1
![0829225625732197](https://github.com/boradorying/appleMarket/assets/136980408/52edf71f-4bd3-4186-a2c7-58e3ba0d7b88)
-이것또한 boolean ,If문을 이용해 꽉찬하트일 때 클릭시 '관심목록제거됨'메시지 snackbar로 띄움
-boolean if문을 통해 클릭시 like --도 전달

### 5. 오른쪽 상단 종 아이콘 클릭하면 알람오게 하기
![0829230005976025](https://github.com/boradorying/appleMarket/assets/136980408/b815695c-1a69-4a1e-994a-d5eca5671251)
-notification 이용

### 6.해당아이템 롱클릭시 삭제 알람과 삭제기능 & 뒤로가기 버튼눌렀을 때 죵료알람과 종료기능
![0829230118384117](https://github.com/boradorying/appleMarket/assets/136980408/e63ef5cb-0012-4c03-9ca0-4e4b9090db1a)

-RecyclerView의 OnItemLongClickListener 인터페이스로 구현
-해당 아이템 롱클릭시 showDeleteConfirmationDialog 함수 호출함으로써 다이얼로그 띄우고 rvAdapter.removeItem(position) ,  rvAdapter.notifyDataSetChanged()
만들어뒀던 삭제 함수로 해당아이템의 포지션 삭제하고 리싸이클러뷰 업데이트
-뒤로가기 눌렀을 시  override fun onBackPressed() 메서드 이용 함으로써  AlertDialog.Builder 종료 확인 알람띄우고 종료 finish()


            ### 나머지 추가 구현 기능들
            -플로팅 버튼이 맨위에 스크롤에 있을 시 없다가 스크롤 내릴 때 fade로 천천히 나타나기
            -플로팅 버튼 눌렀을 때 스크롤 맨위로 이동
------------------------------
## 구현동영상

https://boradoritech-ai.tistory.com/47







## 사용 기술 및 라이브러리

- **Android Kotlin**: 안드로이드 앱을 개발하기 위한 주요 프로그래밍 언어로 사ㅇ용
- **RecyclerView**: 채팅 목록 화면과 개인 채팅 창에서 아이템들을 효율적으로 표시하기 위해 사용

# 프로젝트 제목

**당근마켓 클론코딩: apple_market**

## 프로젝트 설명 및 목적

이 프로젝트는 당근마켓을 클론코딩하여 다음과 같은 목표를 가지고 진행되었습니다:
- 사용자들에게 좋아요(Like) 기능을 제공합니다.
- 아이템 삭제 기능을 구현합니다.
- 리싸이클러뷰(RecyclerView)를 활용하여 아이템을 효율적으로 표시합니다.


## 구체적인 설명

### 1. 메인페이지 (리싸이클러뷰 활용) & 디테일페이지(리싸이클러뷰의 아이템)

![메인페이지](https://github.com/boradorying/appleMarket/assets/136980408/ec62037b-326e-4356-9fdb-f6bf1ca5d269)

- RecyclerView를 사용하여 아이템들을 스크롤 가능하게 정렬합니다.
- RecyclerView의 OnItemLongClickListener를 활용하여 아이템을 클릭했을 때 아이템 상세페이지로 이동합니다.

### 2. 디테일페이지에서 하트 이모티콘 클릭시 Fill 하트로 변경 & Snackbar 메시지 띄우기

![디테일페이지](https://github.com/boradorying/appleMarket/assets/136980408/2f209244-4e71-4f81-afb7-d58d1adc896b)

- 디테일 페이지에서 하트 버튼 클릭 시 꽉찬 하트로 변경하는데 boolean 변수를 활용합니다.
- Snackbar 메시지를 띄우며 하트 클릭 시 '관심목록 추가됨'을 표시하기 위해 showSnackBarMessage를 사용합니다.

### 3. 디테일페이지에서 하트 이모티콘 클릭시 메인페이지에 있는 해당 아이템의 like 카운트 +1되고 하트 이모티콘도 마찬가지로 Fill 하트로 변경

![하트 이모티콘](https://github.com/boradorying/appleMarket/assets/136980408/786a1cf6-57c8-4b6b-aa66-96575bcbce05)

- startActivityForResult를 이용하여 데이터 결과를 주고 받습니다. (다음에는 registerForActivityResult를 사용해보세요)
- boolean 변수를 활용하여 like++ 도 함께 전달합니다.

### 4. 메인페이지에서 하트 이모티콘이 색칠된 아이템의 디테일 페이지로 돌아가면 꽉찬 하트로 되어있을 시 클릭하면 빈 하트로 변경, Snackbar로 '관심목록 제거됨'을 띄우고 해당 아이템의 라이크 카운트 -1

![하트 색칠된 아이템](https://github.com/boradorying/appleMarket/assets/136980408/52edf71f-4bd3-4186-a2c7-58e3ba0d7b88)

- 이 역시 boolean과 if문을 이용하여 꽉찬 하트일 때 클릭 시 '관심목록 제거됨' 메시지를 Snackbar로 표시합니다.
- boolean과 if문을 활용하여 클릭 시 like--를 전달합니다.

### 5. 오른쪽 상단 종 아이콘 클릭하면 알람이 오도록 구현

![알람 아이콘](https://github.com/boradorying/appleMarket/assets/136980408/b815695c-1a69-4a1e-994a-d5eca5671251)

- Notification을 이용하여 오른쪽 상단 종 아이콘을 클릭할 때 알람을 표시합니다.

### 6. 해당 아이템을 롱클릭하면 삭제 알람과 삭제 기능, 뒤로가기 버튼을 눌렀을 때 알람 및 종료 기능 구현

![아이템 삭제](https://github.com/boradorying/appleMarket/assets/136980408/e63ef5cb-0012-4c03-9ca0-4e4b9090db1a)

- RecyclerView의 OnItemLongClickListener 인터페이스를 활용하여 해당 아이템을 롱클릭하면 다이얼로그를 표시하고, rvAdapter.removeItem(position) 및 rvAdapter.notifyDataSetChanged()를 통해 해당 아이템의 위치를 삭제하고 리싸이클러뷰를 업데이트합니다.
- 뒤로가기 버튼을 누를 때 AlertDialog.Builder를 이용하여 종료 확인 알람을 표시하고 앱을 종료합니다.

### 추가 구현 기능

- 플로팅 버튼이 맨 위에 있을 때는 보이지 않고, 스크롤을 내릴 때 천천히 나타나도록 구현합니다.
- 플로팅 버튼을 클릭하면 스크롤이 맨 위로 이동합니다.

## 구현 동영상

프로젝트의 구현 내용을 시연하는 동영상을 아래 링크에서 확인하실 수 있습니다:
[프로젝트 시연 동영상](https://boradoritech-ai.tistory.com/47)

## 사용 기술 및 라이브러리

- **Android Kotlin**: 안드로이드 앱 개발에 사용되는 주요 프로그래밍 언어입니다.
- **RecyclerView**: 아이템 목록을 표시하기 위해 사용되며 효율적인 아이템 관리를 지원합니다.
- **Notification**: 사용자에게 알람을 표시하기 위해 사용됩니다.

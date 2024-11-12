> # Zombie Game

자바 다형성 콘솔 게임 구현

<br>

### 게임 설명
> - 1~10의 칸 이동
> - Enemy를 만나면 전투 실행
> - 마지막 10번 칸에 도달하면 종료
> - Boss를 잡기 위해서는 추가적으로 무기 강화가 필요

<br><br>

### Class Diagram
![클래스다이어그램](https://github.com/SG5143/zombi/blob/main/resources/classDiagram.png)

<br><br>

### Demo
<img src ="https://github.com/SG5143/zombi/blob/main/resources/upgrade.gif" width="400">
<br>
<img src ="https://github.com/SG5143/zombi/blob/main/resources/zombie.gif" width="400">

<br><br>

### Tree
```
📦src
 ┣ 📂constants
 ┃ ┗ 📜WeaponConstants.java
 ┣ 📂interfaces
 ┃ ┗ 📜Enemy.java
 ┣ 📂units
 ┃ ┣ 📜Boss.java
 ┃ ┣ 📜Hero.java
 ┃ ┣ 📜Unit.java
 ┃ ┗ 📜Zombie.java
 ┗  📂zombi
   ┣ 📜Game.java
   ┗ 📜Main.java

```

> # Zombie Game

자바 다형성 콘솔 게임 구현

<br>

### 게임 설명
> - 맵은 1~20의 칸 으로 구성되어 있습니다.
> - 플레이어는 한칸씩 이동 가능합니다.
> - Zombie 또는 BossZombie 를 만나면 전투 실행
> - 마지막 20번 칸에 도달하거나 플레이어가 죽으면 게임은 종료됩니다.
> - Boss와 Zombie 는 각각 4개, 2개의 스킬을 보유하고 있습니다.

<br><br>

### Class Diagram
![클래스다이어그램](https://github.com/sungwoni9/zombie/blob/main/resource/classDiagram.png)

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

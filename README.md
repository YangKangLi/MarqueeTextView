# MarqueeTextView

![Platform](https://img.shields.io/badge/platform-Android-blue.svg)  ![Release](https://img.shields.io/badge/release-1.0-blue.svg)  ![Gradle](https://img.shields.io/badge/gradle-3.5.3-blue.svg)  ![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)
=====

Description
=====
You can adjust the marquee speed TextView control

Usage
=====

Step 1.Add the JitPack repository to your build file, add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```
dependencies {
		implementation 'com.github.YangKangLi:MarqueeTextView:1.0'
	}
```
Step 3. Use MarqueeTextView Widget like :
```
<com.github.yangkangli.marquee_text_view.MarqueeTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:lines="1"
        android:text="Default Text View"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:marquee_first_hold_time="1000"
        app:marquee_margin_between="100dp"
        app:marquee_move_step="5" />
```
There are 3 arrtrbutes here:
1) marquee_first_hold_time : it means that text will hold for a while before scrooll
2) marquee_margin_between: coming soon
3) marquee_move_step: coming soon

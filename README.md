# RemoteControl
### Android权威编程指南第24章电视遥控器应用

1. 锁定activity的视图以竖直方向展示`android:screenOrientation="portrait"`
2. 确保表格布局的列都有同样的宽度`android:stretchColumns="*"`
3. 提取公共样式到styles中
     `<style name="RemoteButton">
         <item name="android:layout_width">0dp</item>
         <item name="android:layout_height">match_parent</item>
     </style>`
     `style="@style/RemoteButton"`
4. include引入布局文件.xml
        `<include
                 layout="@layout/button_row"
                 android:layout_weight="1"/>`

### Android权威编程指南第25章电视遥控器应用
1. XML drawable与特定的像素密度无关，无需考虑特定的像素密度
2. state list drawable
3. layer list
4. inset drawable
5. 9-patch图像


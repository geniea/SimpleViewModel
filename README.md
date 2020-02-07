# \[Kotlin]Android Architecture ::ViewModel

## Activity Lifecycle과 ViewModel

Activity Lifecycle과 분리하여 Activity의 데이터를 관리하기 위하여 사용함. ViewModel 객체의 데이터는 Activity가 재실행되어도 소멸하지 않음.

![enter image description here](https://user-images.githubusercontent.com/60108801/74001409-d1ba3500-49ae-11ea-8943-70e349e3dc45.png)

아래의 코드는 Activity 재 실행시 값이 초기화 됨
```java
class MainActivity : AppCompatActivity() {

    private var v: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plus_button.setOnClickListener {
            plusOne()
        }
    }

    private fun plusOne(){
        v++
        count_textView.text = v.toString()
    }
}
```

### Step 1. dependency 및 ViewModel 클래스 추가
build.gradle (Module: app) 에 gradle dependency 추가

```
//ViewModel
implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
```

SimpleViewModel class 추가 및 override onCleared()

```java
import androidx.lifecycle.ViewModel

class SimpleViewModel() : ViewModel() {

    var cnt = 0

    override fun onCleared() {
        super.onCleared()
    }
}
```
### Step 2. UI controller(Activity) 에 viewModel 선언 및 데이터 사용

```java
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SimpleViewModel::class.java)
        count_textView.text = viewModel.cnt.toString()
        plus_button.setOnClickListener {
            plusOne()
        }
    }

    private fun plusOne(){
        viewModel.cnt++
        count_textView.text = viewModel.cnt.toString()
    }
}
```

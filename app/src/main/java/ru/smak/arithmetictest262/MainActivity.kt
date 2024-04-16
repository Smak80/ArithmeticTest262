package ru.smak.arithmetictest262

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.smak.arithmetictest262.ui.theme.ArithmeticTest262Theme
import kotlin.math.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArithmeticTest262Theme {
                ArithmeticCard(Task())
            }
        }
    }
}

@Composable
fun ArithmeticCard (task: Task, modifier: Modifier = Modifier) {
    var answer by remember { mutableStateOf("") }
    ElevatedCard (modifier = modifier){
        Column (
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (verticalAlignment = Alignment.CenterVertically){
                Text("${task.a} ${task.oper.symbol} ${task.b} = ",
                    modifier = Modifier.weight(0.65f),
                    fontSize = 40.sp)
                OutlinedTextField(
                    value = answer,
                    onValueChange = {
                        if (
                            it.isBlank()
                            || it == "-"
                            || it.toIntOrNull() != null
                            ) answer = it.trim().slice(
                            0..min(3, it.trim().length - 1)
                            )
                                    },
                    modifier = Modifier.weight(0.35f),
                    textStyle = TextStyle(fontSize = 40.sp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
            }
            FilledIconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.baseline_check_24), contentDescription = stringResource(id = R.string.btn_chek))
            }
        }
    }
}

@Preview
@Composable
fun ArithmeticCardPreview(){
    ArithmeticTest262Theme{
        ArithmeticCard(Task())
    }
}
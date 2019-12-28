package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.example.exercise3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            calculate()
        }
        binding.buttonReset.setOnClickListener{
            resetButton()
        }
    }

    private fun calculate(){
        val age = binding.spinnerAge.selectedItem
        val gender = resources.getResourceEntryName(binding.radioGroupGender.checkedRadioButtonId)
        val smoker = binding.checkBoxSmoker.isChecked
        var price: Int

        if(age == "Less than 17"){
            price = 60
        }else if(age == "17 to 25"){
            price = 70
            if(gender == "radioButtonMale"){
                price += 50
            }
            if(smoker){
                price += 100
            }
        }else if(age == "26 to 30"){
            price = 90
            if(gender == "radioButtonMale"){
                price += 100
            }
            if(smoker){
                price += 150
            }
        }else if(age == "31 to 40"){
            price = 120
            if(gender == "radioButtonMale"){
                price += 150
            }
            if(smoker){
                price += 200
            }
        }else if(age == "41 to 55"){
            price = 150
            if(gender == "radioButtonMale"){
                price += 200
            }
            if(smoker){
                price += 250
            }
        }else{
            price = 150
            if(gender == "radioButtonMale"){
                price += 200
            }
            if(smoker){
                price += 300
            }
        }
        
        binding.textViewPremium.text = "Insurance Premium: RM" + price
    }

    private fun resetButton(){
        binding.spinnerAge.setSelection(0)
        binding.radioGroupGender.clearCheck()
        binding.checkBoxSmoker.isChecked = false
        binding.textViewPremium.text = "Insurance Premium: "
    }

}

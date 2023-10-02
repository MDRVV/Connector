package com.rcl.connector.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel

class MainScreen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
        mainViewModel: MainScreenViewModel = viewModel()
    ) {
        val streetRequester = remember { FocusRequester() }
        val houseRequester = remember { FocusRequester() }
        LaunchedEffect(Unit) {
            streetRequester.requestFocus()
        }

        Scaffold { paddings ->
            Box(modifier = Modifier.padding(paddings)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
                        Column(modifier = Modifier.fillMaxWidth().padding(all = 10.dp)) {
                            Box {
                                var text by remember { mutableStateOf("") }
                                var expanded by remember { mutableStateOf(false) }
                                ExposedDropdownMenuBox(
                                    expanded = expanded,
                                    onExpandedChange = {
                                        expanded = false
                                    }
                                ) {
                                    TextField(
                                        singleLine = true,
                                        placeholder = {
                                            Text(text = "Выберите улицу..")
                                        },
                                        value = text,
                                        onValueChange = {
                                            text = it
                                            mainViewModel.selectedStreetID.value = ""
                                            if (mainViewModel.houseList.isNotEmpty()){ mainViewModel.clearHouses() }
                                            if (mainViewModel.streetInList.value){
                                                mainViewModel.streetInList.value = false
                                            }
                                            if (text.length >= 3 && !expanded) {
                                                expanded = true
                                            }
                                        },
                                        modifier = Modifier.menuAnchor().fillMaxWidth().focusRequester(streetRequester)
                                    )
                                    DropdownMenu(
                                        expanded = expanded,
                                        modifier = Modifier.heightIn(0.dp, 300.dp).fillMaxWidth()
                                            .padding(horizontal = 20.dp),
                                        properties = PopupProperties(focusable = false),
                                        onDismissRequest = {
                                            expanded = false
                                        }
                                    ) {
                                        mainViewModel.streetList.toList().filter { it.street!!.contains(text) }
                                            .forEach { item ->
                                                DropdownMenuItem(
                                                    text = { Text(text = item.street!!) },
                                                    onClick = {
                                                        text = item.street!!
                                                        expanded = false
                                                        mainViewModel.selectedStreetID.value = item.streetId!!
                                                        mainViewModel.streetInList.value = true
                                                        mainViewModel.getHouses(mainViewModel.selectedStreetID.value)
                                                    }
                                                )
                                            }
                                    }
                                }
                            }
                            if (mainViewModel.selectedStreetID.value.isNotEmpty() && mainViewModel.streetInList.value) {
                                var expanded by remember { mutableStateOf(true) }
                                var text by remember { mutableStateOf("") }
                                LaunchedEffect(Unit) {
                                    houseRequester.requestFocus()
                                }
                                ExposedDropdownMenuBox(
                                    expanded = expanded,
                                    onExpandedChange = {
                                        expanded = false
                                    }
                                ) {
                                    TextField(
                                        singleLine = true,
                                        placeholder = {
                                            Text(text = "Выберите дом..")
                                        },
                                        value = text,
                                        onValueChange = {
                                            text = it
                                            mainViewModel.selectedHouseID.value = ""
                                            if (mainViewModel.houseInList.value){
                                                mainViewModel.houseInList.value = false
                                            }
                                            if (!expanded){
                                                expanded = true
                                            }
                                        },
                                        modifier = Modifier.menuAnchor().fillMaxWidth().focusRequester(houseRequester)
                                    )
                                    DropdownMenu(
                                        expanded = expanded,
                                        modifier = Modifier.heightIn(0.dp, 300.dp).fillMaxWidth()
                                            .padding(horizontal = 20.dp),
                                        properties = PopupProperties(focusable = false),
                                        onDismissRequest = {
                                            expanded = false
                                        }
                                    ) {
                                        mainViewModel.houseList.toList().filter { it.house!!.contains(text) }
                                            .forEach {item ->
                                            DropdownMenuItem(
                                                text = { Text(text = item.house!!) },
                                                onClick = {
                                                    text = item.house!!
                                                    expanded = false
                                                    mainViewModel.selectedHouseID.value = item.houseId!!
                                                    mainViewModel.houseInList.value = true
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                if (!mainViewModel.streetInList.value || !mainViewModel.houseInList.value) {
                                    var house by remember { mutableStateOf("") }
                                    OutlinedTextField(
                                        label = {
                                            Text(text = "Дом")
                                        },
                                        singleLine = true,
                                        placeholder = {
                                            Text(text = "Дом")
                                        },
                                        value = house,
                                        onValueChange = {
                                            house = it
                                            mainViewModel.customHouse.value = it
                                            if(!mainViewModel.isCustomHouse.value){
                                                mainViewModel.isCustomHouse.value = true
                                            }
                                        },
                                        modifier = Modifier.fillMaxWidth().weight(1f)
                                    )
                                    var frame by remember { mutableStateOf("") }
                                    OutlinedTextField(
                                        label = {
                                            Text(text = "Корпус")
                                        },
                                        singleLine = true,
                                        placeholder = {
                                            Text(text = "Корпус")
                                        },
                                        value = frame,
                                        onValueChange = {
                                            frame = it
                                            mainViewModel.customFrame.value = it
                                            if(!mainViewModel.isCustomHouse.value){
                                                mainViewModel.isCustomHouse.value = true
                                            }
                                        },
                                        modifier = Modifier.fillMaxWidth().weight(1f)
                                    )
                                }
                                var apartment by remember { mutableStateOf("") }
                                OutlinedTextField(
                                    label ={
                                        Text(text = "Квартира")
                                    },
                                    singleLine = true,
                                    placeholder = {
                                        Text(text = "Квартира")
                                    },
                                    value = apartment,
                                    onValueChange = {
                                        apartment = it
                                        mainViewModel.apartment.value = it
                                    },
                                    modifier = Modifier.fillMaxWidth().weight(1f)
                                )
                            }
                        }
                    }
                    val context = LocalContext.current
                    Button(
                        enabled = (mainViewModel.apartment.value.isNotEmpty()&&(mainViewModel.streetInList.value&&mainViewModel.houseInList.value||mainViewModel.isCustomHouse.value&&mainViewModel.selectedStreetID.value.isNotEmpty()&&mainViewModel.customHouse.value.isNotEmpty()&&mainViewModel.customFrame.value.isNotEmpty())),
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        onClick = {
                                  Toast.makeText(
                                      context,
                                      (if (mainViewModel.streetInList.value){ "ID улицы - ${mainViewModel.selectedStreetID.value}, " }else{"Улица - ${mainViewModel.selectedStreetID.value}, "})
                                      + if(mainViewModel.isCustomHouse.value){"Дом - ${mainViewModel.customHouse.value} ${if(mainViewModel.customFrame.value.isNotEmpty()){"Корпус - ${mainViewModel.customFrame.value}, "} else { ", " }}"}else{"ID дома - ${mainViewModel.selectedHouseID.value}, "}
                                      + "Квартира - ${mainViewModel.apartment.value}",
                                      Toast.LENGTH_SHORT).show()
                                                          },
                        content = {
                            Text(
                                text = "Отправить"
                            )
                        }
                    )
                }
            }
        }
    }
}
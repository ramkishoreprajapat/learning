import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter_baby_name_sdk/flutter_baby_name_sdk.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: Scaffold(body: ElevatedButton(onPressed: (){
        final babyNameManager = BabyNameManager.instance;
          log("Baby name count");
          log(babyNameManager.getTotalRecords().toString());
     } ,
      child: Text("Click Me", style: TextStyle(color: Colors.black, fontSize: 50),)),),
    );
  }
}


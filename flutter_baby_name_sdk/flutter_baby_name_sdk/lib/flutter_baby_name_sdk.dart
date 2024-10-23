library flutter_baby_name_sdk;

import 'dart:async';
import 'dart:math';

import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

class BabyNameManager {
  final String table = 'babynamestable';
  final String columnId = 'babyid';
  final String columnName = 'name';
  final String columnAge = 'age';

  // make this a singleton class
  BabyNameManager._privateConstructor();
  static final BabyNameManager instance = BabyNameManager._privateConstructor();

  // only have a single app-wide reference to the database
  Future<Database?> get database async {
    if (_database != null) return _database;

    String path = join('assets', 'BabyNamesDB.sqlite');
    await open(path);
    return _database;
  }

  static Database? _database;
  Future open(String path) async {
    try {
      var exists = await databaseExists(path);
      if (exists) {
        _database = await openDatabase(
          path,
          version: 1,
        );
      } else {
        print('Database not exists');
      }
    } catch (e) {
      print(e);
    }
  }

  Future<int?> getTotalRecords() async {
    Database? db = await instance.database;
    return Sqflite.firstIntValue(
        await db!.rawQuery('SELECT COUNT(*) FROM $table'));
  }

  Future close() async {
    Database? db = await instance.database;
    db!.close();
  }
}

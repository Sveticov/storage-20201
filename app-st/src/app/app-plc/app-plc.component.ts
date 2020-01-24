import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {PLCData} from "./PLCData";


@Component({
  selector: 'app-app-plc',
  templateUrl: './app-plc.component.html',
  styleUrls: ['./app-plc.component.css']
})
export class AppPlcComponent implements OnInit {
  private host = 'http://localhos:8080/app/plc/newplc'
  plcDataL: PLCData

  constructor(private http: HttpClient) {
    this.plcDataL=new PLCData()
  }

  ngOnInit() {
  }


  plcSubmit(plcForm: NgForm) {
    console.log(plcForm.value)
    // this.plcDataL.adrIP = plcForm.value.adrIP
    // this.plcDataL.lengthRead = plcForm.value.lengthRead
    // this.plcDataL.lengthWrite = plcForm.value.lengthWrite
    // this.plcDataL.dbRead = plcForm.value.dbRead
    // this.plcDataL.dbWrite = plcForm.value.dbWrite
    // this.plcDataL.rack = plcForm.value.rack
    // this.plcDataL.slot = plcForm.value.slot
    this.savePLC(this.plcDataL).subscribe()
  }

  savePLC(plc: PLCData) {
    return this.http.post<PLCData>(this.host, plc)
  }
}

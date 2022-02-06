import { Address } from "./Address";


export class Register{



  constructor(
      public username:String,
      public password:String,
      public first_name:String,
      public last_name:String,
      public email_address:String,
      public address: Address
      // public address_1:String,
      // public city:String,
      // public state:String,
      // public country:String,
      // public postal_code:string

  ){}
}

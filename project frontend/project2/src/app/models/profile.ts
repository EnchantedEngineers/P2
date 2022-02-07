<<<<<<< HEAD
=======
import { Address } from "./Address";
>>>>>>> 341299bfc05f75f6c0809402b4a45542746459f8


export class Register{



  constructor(
      public username:String,
      public password:String,
<<<<<<< HEAD
      public firstname:String,
      public lastname:String,
      public email_address:String,
      public address:String,
      public city:String,
      public state:String,
      public country:String,
      public postal_code:string
=======
      public first_name:String,
      public last_name:String,
      public email_address:String,
      public address: Address
      // public address_1:String,
      // public city:String,
      // public state:String,
      // public country:String,
      // public postal_code:string
>>>>>>> 341299bfc05f75f6c0809402b4a45542746459f8

  ){}
}

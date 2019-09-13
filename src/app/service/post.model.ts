import { User } from './user.model';

export class Post{
    id:number;
    userId:User;
    image:String;
    liked:number;
    unlike:number;
    comments:String;
    title:String;
    description:String;

    
}
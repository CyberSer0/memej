import CommentInterface from "./comment.interface";
import TagInterface from "./tag.interface";
import UserInterface from "./user.interface";

export default interface MemeInterface {
    id: number,
    title: string,
    image: string,
    pluses: number,
    minuses: number,
    comments: CommentInterface[],
    author: UserInterface,
    tags: TagInterface[];
}


import UserInterface from "./user.interface";

export default interface CommentInterface {
    id: number,
    author: UserInterface,
    content: string,
    comments?: CommentInterface[],
    pluses: number,
    minuses: number;
}

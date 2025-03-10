import Details from "./Details";
import Posts from "./Posts";
import { useState } from "react";

export default function Dashboard() {

    const defaultPosts = [
        { id: 111, title: "Happiness", author: "John" },
        { id: 112, title: "MIU", author: "Dean" },
        { id: 113, title: "Enjoy Life", author: "Jasmine" }
    ];
    const [posts, setPosts] = useState(defaultPosts);
    const [newTitle, setNewTitle] = useState("");
    const [postDetails, setPostDetails] = useState(null);

    const changeTitle = () => {
        if (newTitle.trim() === "") return;

        const updatedPosts = posts.map((post, index) =>
            index === 0 ? { ...post, title: newTitle } : post
        );

        setPosts(updatedPosts);
        setNewTitle("");
    };


    return (
        <>
            <div className="container">
                <h1 className="text-center pt-4">Dashboard</h1>
                <hr />
                <Posts setPostDetails={setPostDetails} posts={posts} />
                <hr />
                <div className="row">
                    <div className="col-4">
                        <input type="text" onChange={(e) => setNewTitle(e.target.value)} value={newTitle} placeholder="Title Here" className="form-control" />
                    </div>
                    <div className="col-4">
                        <button onClick={changeTitle} className="btn btn-primary btn-sm h-100">Change Title</button>
                    </div>
                </div>
                {
                    postDetails && <Details details={postDetails} />}
            </div>
        </>
    )
}

import { useRef } from "react";
import { useNavigate } from "react-router-dom";
import API_BASE_URL from "../config";

const NewPost = () => {
    const titleRef = useRef();
    const authorRef = useRef();
    const contentRef = useRef();
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const newPost = {
            title: titleRef.current.value,
            author: authorRef.current.value,
            content: contentRef.current.value,
        };

        fetch(`${API_BASE_URL}/posts`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            content: JSON.stringify(newPost),
        })
            .then(() => navigate("/"))
            .catch((err) => console.error(err));
    };

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold mb-4">Create New Post</h2>
            <form onSubmit={handleSubmit} className="space-y-4">
                <input ref={titleRef} className="border p-2 w-full" placeholder="Title" required />
                <input ref={authorRef} className="border p-2 w-full" placeholder="Author" required />
                <textarea ref={contentRef} className="border p-2 w-full" placeholder="Content" required />
                <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">Add Post</button>
            </form>
        </div>
    );
};

export default NewPost;

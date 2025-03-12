import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API_BASE_URL from "./config";

const AddPost = () => {
    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [content, setContent] = useState("");
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const newPost = { title, author, body: content };

        fetch(`${API_BASE_URL}/posts`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newPost),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to add post");
                }
                return response.json();
            })
            .then(() => {
                navigate("/");
            })
            .catch((err) => setError(err.message));
    };

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold mb-4">Add New Post</h2>
            {error && <p className="text-red-500">{error}</p>}
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label className="block font-semibold">Title:</label>
                    <input
                        type="text"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        required
                        className="w-full p-2 border rounded"
                    />
                </div>
                <div>
                    <label className="block font-semibold">Author:</label>
                    <input
                        type="text"
                        value={author}
                        onChange={(e) => setAuthor(e.target.value)}
                        required
                        className="w-full p-2 border rounded"
                    />
                </div>
                <div>
                    <label className="block font-semibold">Content:</label>
                    <textarea
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                        required
                        className="w-full p-2 border rounded h-32"
                    />
                </div>
                <button
                    type="submit"
                    className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700"
                >
                    Add Post
                </button>
            </form>
        </div>
    );
};

export default AddPost;

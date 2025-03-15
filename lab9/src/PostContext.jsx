
import { createContext, useState, useContext } from "react";

const PostContext = createContext();

export const PostProvider = ({ children }) => {
    const [selectedPostId, setSelectedPostId] = useState(null);

    return (
        <PostContext.Provider value={{ selectedPostId, setSelectedPostId }}>
            {children}
        </PostContext.Provider>
    );
};

export const usePostContext = () => useContext(PostContext);

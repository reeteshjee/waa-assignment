import Posts from "./Posts";


const DashBoard = () => {
    return (
        <div className="container mx-auto p-6">
            <h1 className="text-3xl font-bold mb-6">Dashboard</h1>
            <Posts />
        </div>
    );
};

export default DashBoard;


import { Link } from 'react-router-dom';

export default function Header() {
    return (
        <>
            <div className="row header">
                <div className="col-9">
                    <div className="text-center">
                        <Link to="/">
                            Posts
                        </Link>
                        <Link to="/new-post">
                            New Post
                        </Link>
                    </div>
                </div>
                <div className="col-3">
                    <Link to="/login">
                        Sign In
                    </Link>
                </div>
            </div>
        </>
    )
}
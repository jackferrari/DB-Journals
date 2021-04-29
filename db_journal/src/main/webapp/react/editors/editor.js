import EditorList from "./editor-content/editor-list";
import EditorFormEditor from "./editor-content/editor-form-editor";
import ArticlesList from "./editor-content/editor-articles-list";
import UsersList from "./editor-content/editor-users-list";

const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/editors", "/"]} exact={true}>
                    <EditorList/>
                </Route>
                <Route path="/editors/:id" exact={true}>
                    <EditorFormEditor/>
                </Route>
                <Route path="/editors/:id/articles" exact={true}>
                    <ArticlesList/>
                </Route>
                <Route path="/editors/:id/users" exact={true}>
                    <UsersList/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;

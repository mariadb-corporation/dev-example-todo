import flask
from tasks import tasks

app = flask.Flask(__name__)
app.config["DEBUG"] = True
app.register_blueprint(tasks)

@app.route("/api/version")
def version():
    return "1.0"

app.run(port=8080)
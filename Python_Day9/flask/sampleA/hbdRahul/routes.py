from hbdRahul import app
@app.route('/')
@app.route('/niit')
def niit():
    return "Have a great day Rahul"

@app.route('/deloitte')
def welcome():
    return "<h1>Have a great day Rahul</h1>"

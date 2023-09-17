 const oracledb = require('oracledb');
    const dbConfig = {
    user : 'AULAAPP',
    password : 'AULAAPP',
    connectString : ''
    };


    (async function() {
    let conn; // Declared here for scoping purposes

    try {
        conn = await oracledb.getConnection(dbConfig);

        console.log('Connected to database');

        let result = await conn.execute(
            'select * from usuario',
            [], // no binds
            {
                outFormat: oracledb.OBJECT
            }
    );

        console.log('Query executed');
        console.log(result.rows);
    } catch (err) {
        console.log('Error in processing', err);
    } finally {
        if (conn) { // conn assignment worked, need to close
            try {
                await conn.close();

                console.log('Connection closed');
            } catch (err) {
                console.log('Error closing connection', err);
            }
        }
    }
    })();
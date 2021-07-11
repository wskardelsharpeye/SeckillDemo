SELECT u.id as userId, u.username, u.password, r.id as roleId, r.role, p.id as permissionId, p.permission FROM user u, userrole ur, role r, permission p, rolepermission rp WHERE u.id = ur.userid AND ur.roleid = r.id AND r.id = rp.roleid AND rp.permissionid = p.id AND u.username = 'admin';

SELECT
    u.id as userId,
    u.username,
    u.password,
    r.id as roleId,
    r.role,
    p.id as permissionId,
    p.permission
FROM user u,
     LEFT JOIN userrole ur on u.id = ur.userid,
     LEFT JOIN role r on ur.roleid = r.id,
     LEFT JOIN permission p on r.id = rp.roleid,
     LEFT JOIN rolepermission rp on rp.permissionid = p.id
WHERE
  AND u.id = #{id}